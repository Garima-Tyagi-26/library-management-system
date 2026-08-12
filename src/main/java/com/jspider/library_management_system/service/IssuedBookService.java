package com.jspider.library_management_system.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.jspider.library_management_system.dao.BookDao;
import com.jspider.library_management_system.dao.IssuedBookDao;
import com.jspider.library_management_system.dao.MemberDao;
import com.jspider.library_management_system.dto.Book;
import com.jspider.library_management_system.dto.IssuedBook;
import com.jspider.library_management_system.dto.Member;

public class IssuedBookService {

    private IssuedBookDao issuedBookDao = new IssuedBookDao();
    private BookDao bookDao = new BookDao();
    private MemberDao memberDao = new MemberDao();

    public IssuedBook issueBook(IssuedBook issuedBook) {

        // 1. Check whether book exists
        Book book = bookDao.getBookById(issuedBook.getBookId());

        if (book == null) {

            System.out.println("Book not found");

            return null;
        }
        
       // 2. Check whether member exists
        Member member = memberDao.getMemberById(issuedBook.getMemberId());

        if (member == null) {

            System.out.println("Member not found");

            return null;
        }

        // 3. Check whether copies are available
        if (book.getAvailableCopies() <= 0) {

            System.out.println("Book is currently unavailable");

            return null;
        }

        // 4. Decrease available copies
        boolean copiesUpdated =
                bookDao.decreaseAvailableCopies(issuedBook.getBookId());

        if (!copiesUpdated) {

            System.out.println("Could not update available copies");

            return null;
        }

        // 5. Create issue record
        IssuedBook result =
                issuedBookDao.issueBook(issuedBook);

        if (result == null) {

            // Something went wrong while creating the issue record.
            // We should restore the available copy.
            bookDao.increaseAvailableCopies(issuedBook.getBookId());

            return null;
        }

        return result;
    }
    
    
    
    public boolean returnBook(int issueId) {

        // 1. Find the active issue record
        IssuedBook issuedBook =
                issuedBookDao.getActiveIssueById(issueId);

        if (issuedBook == null) {

            System.out.println("Active issue record not found");

            return false;
        }

        // 2. Get today's date
        LocalDate returnDate = LocalDate.now();

        // 3. Get due date
        LocalDate dueDate =
                issuedBook.getDueDate().toLocalDate();

        // 4. Calculate fine
        double fineAmount = 0.00;

        if (returnDate.isAfter(dueDate)) {

            long overdueDays =
                    ChronoUnit.DAYS.between(dueDate, returnDate);

            double finePerDay = 5.00;

            fineAmount = overdueDays * finePerDay;
        }

        // 5. Convert LocalDate to java.sql.Date
        Date sqlReturnDate =
                Date.valueOf(returnDate);

        // 6. Update issued_book table
        boolean returned =
                issuedBookDao.returnBook(issueId, sqlReturnDate, fineAmount);

        if (!returned) {

            System.out.println("Could not return book");

            return false;
        }

        // 7. Increase available copies
        boolean copiesUpdated =
                bookDao.increaseAvailableCopies(
                        issuedBook.getBookId()
                );

        if (!copiesUpdated) {

            System.out.println(
                    "Book returned but available copies could not be updated"
            );

            return false;
        }

        return true;
    }
    
    
    
    public List<IssuedBook> getAllIssuedBooks() {

        return issuedBookDao.getAllIssuedBooks();
    }
}