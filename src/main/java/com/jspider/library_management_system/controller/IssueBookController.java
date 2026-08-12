package com.jspider.library_management_system.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import com.jspider.library_management_system.dto.IssuedBook;
import com.jspider.library_management_system.service.IssuedBookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/issue-book")
public class IssueBookController extends HttpServlet {

    private IssuedBookService issuedBookService =
            new IssuedBookService();

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        int bookId = Integer.parseInt(req.getParameter("bookId"));

        int memberId = Integer.parseInt(req.getParameter("memberId"));

        // Automatically calculate issue date
        LocalDate issueDate = LocalDate.now();

        // Borrowing period = 14 days
        LocalDate dueDate = issueDate.plusDays(14);

        // Convert LocalDate to java.sql.Date
        Date sqlIssueDate = Date.valueOf(issueDate);

        Date sqlDueDate = Date.valueOf(dueDate);

        IssuedBook issuedBook = new IssuedBook();

        issuedBook.setBookId(bookId);
        issuedBook.setMemberId(memberId);
        issuedBook.setIssueDate(sqlIssueDate);
        issuedBook.setDueDate(sqlDueDate);
        issuedBook.setFineAmount(0.00);

        IssuedBook result = issuedBookService.issueBook(issuedBook);

        if (result != null) {

        	resp.sendRedirect("books.jsp");

        } else {

            resp.sendRedirect("issue-book.jsp?error=true");
        }
    }
}