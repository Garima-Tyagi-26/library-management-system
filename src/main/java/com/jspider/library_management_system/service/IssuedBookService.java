package com.jspider.library_management_system.service;

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
}