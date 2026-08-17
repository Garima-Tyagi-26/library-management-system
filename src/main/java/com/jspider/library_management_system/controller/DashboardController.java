package com.jspider.library_management_system.controller;

import java.io.IOException;

import com.jspider.library_management_system.service.BookService;
import com.jspider.library_management_system.service.MemberService;
import com.jspider.library_management_system.service.IssuedBookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

    private BookService bookService = new BookService();

    private MemberService memberService = new MemberService();

    private IssuedBookService issuedBookService =
            new IssuedBookService();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get dashboard statistics
        int totalBooks =
                bookService.getTotalBooks();

        int totalMembers =
                memberService.getTotalMembers();

        int totalIssuedBooks =
                issuedBookService.getTotalIssuedBooks();

        // Send data to JSP
        request.setAttribute(
                "totalBooks",
                totalBooks
        );

        request.setAttribute(
                "totalMembers",
                totalMembers
        );

        request.setAttribute(
                "totalIssuedBooks",
                totalIssuedBooks
        );

        // Open dashboard
        request.getRequestDispatcher("index.jsp")
                .forward(request, response);
    }
}
