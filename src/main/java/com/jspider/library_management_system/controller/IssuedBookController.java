package com.jspider.library_management_system.controller;

import java.io.IOException;
import java.util.List;

import com.jspider.library_management_system.dto.IssuedBook;
import com.jspider.library_management_system.service.IssuedBookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/issued-books")
public class IssuedBookController extends HttpServlet {

    private IssuedBookService issuedBookService =
            new IssuedBookService();

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        List<IssuedBook> issuedBooks = issuedBookService.getAllIssuedBooks();

        req.setAttribute("issuedBooks", issuedBooks);

        req.getRequestDispatcher("issued-books.jsp")
                .forward(req, resp);
    }
}