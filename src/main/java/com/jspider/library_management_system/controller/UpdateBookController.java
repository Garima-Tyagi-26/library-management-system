package com.jspider.library_management_system.controller;

import java.io.IOException;

import com.jspider.library_management_system.dto.Book;
import com.jspider.library_management_system.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-book")
public class UpdateBookController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Book book = bookService.getBookById(id);

        if (book != null) {

            request.setAttribute("book", book);

            request.getRequestDispatcher("update-book.jsp")
                   .forward(request, response);

        } else {

            response.getWriter().println("Book not found.");
        }
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String category = request.getParameter("category");

        int totalCopies = Integer.parseInt(request.getParameter("totalCopies"));
        int availableCopies = Integer.parseInt(request.getParameter("availableCopies"));

        Book book = new Book();

        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setCategory(category);
        book.setTotalCopies(totalCopies);
        book.setAvailableCopies(availableCopies);

        Book updatedBook = bookService.updateBook(book);

        if (updatedBook != null) {
            response.sendRedirect("add-book");
        } else {
            response.getWriter().println("Book could not be updated.");
        }
    }
    
}