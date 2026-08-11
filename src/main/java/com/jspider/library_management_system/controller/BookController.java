package com.jspider.library_management_system.controller;

import java.io.IOException;
import java.util.List;

import com.jspider.library_management_system.dto.Book;
import com.jspider.library_management_system.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-book")
public class BookController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String category = request.getParameter("category");
        int totalCopies = Integer.parseInt(request.getParameter("totalCopies"));
        int availableCopies = Integer.parseInt(request.getParameter("availableCopies"));

        Book book = new Book();

        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setCategory(category);
        book.setTotalCopies(totalCopies);
        book.setAvailableCopies(availableCopies);

        Book insertedBook = bookService.addBook(book);

        if (insertedBook != null) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("Book could not be added.");
        }
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        List<Book> books;

        if (keyword != null && !keyword.trim().isEmpty()) {

            books = bookService.searchBooks(keyword);

        } else {

            books = bookService.getAllBooks();
        }

        request.setAttribute("books", books);

        request.setAttribute("keyword", keyword);

        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
