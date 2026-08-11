package com.jspider.library_management_system.service;

import java.util.List;

import com.jspider.library_management_system.dao.BookDao;
import com.jspider.library_management_system.dto.Book;

public class BookService {

    private BookDao bookDao = new BookDao();

    public Book addBook(Book book) {

        if (book == null) {
            return null;
        }

        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            System.out.println("Book title cannot be empty");
            return null;
        }

        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            System.out.println("Author cannot be empty");
            return null;
        }

        if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
            System.out.println("ISBN cannot be empty");
            return null;
        }

        if (book.getTotalCopies() <= 0) {
            System.out.println("Total copies must be greater than 0");
            return null;
        }

        if (book.getAvailableCopies() < 0 ||
            book.getAvailableCopies() > book.getTotalCopies()) {

            System.out.println("Invalid available copies");
            return null;
        }

        return bookDao.insertBook(book);
    }
    
    
    
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
    
    
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
    
    
    public Book updateBook(Book book) {
        return bookDao.updateBook(book);
    }
    
    
    public boolean deleteBook(int id) {
        return bookDao.deleteBook(id);
    }
    
    
    public List<Book> searchBooks(String keyword) {
        return bookDao.searchBooks(keyword);
    }
}
