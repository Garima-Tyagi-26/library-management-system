package com.jspider.library_management_system.controller;

import java.io.IOException;

import com.jspider.library_management_system.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-book")
public class DeleteBookController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        boolean deleted = bookService.deleteBook(id);

        if (deleted) {
            response.sendRedirect("add-book");
        } else {
            response.getWriter().println("Book could not be deleted.");
        }
    }
}
