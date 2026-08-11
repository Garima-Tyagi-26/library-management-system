package com.jspider.library_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.library_management_system.connection.ConnectionFactory;
import com.jspider.library_management_system.dto.Book;
import com.jspider.library_management_system.util.CloseConnectionUtil;

public class BookDao {

    public Book insertBook(Book book) {

        Connection con = null;
        PreparedStatement ps = null;

        final String INSERT_BOOK_QUERY = "INSERT INTO book (title, author, isbn, category, total_copies, available_copies) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = ConnectionFactory.getConnectionFactory();
            ps = con.prepareStatement(INSERT_BOOK_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.setString(4, book.getCategory());
            ps.setInt(5, book.getTotalCopies());
            ps.setInt(6, book.getAvailableCopies());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
            	ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    book.setId(generatedKeys.getInt(1));
                }
                System.out.println("Data inserted Successfully");
                return book;
            }else {
            	System.out.println("something went wrong");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    
    public List<Book> getAllBooks() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Book> books = new ArrayList<>();

        final String SELECT_ALL_BOOKS_QUERY =
                "SELECT id, title, author, isbn, category, total_copies, available_copies FROM book";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(SELECT_ALL_BOOKS_QUERY);

            rs = ps.executeQuery();

            while (rs.next()) {

                Book book = new Book();

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                book.setCategory(rs.getString("category"));
                book.setTotalCopies(rs.getInt("total_copies"));
                book.setAvailableCopies(rs.getInt("available_copies"));

                books.add(book);
            }

            return books;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnectionUtil.closeConnection(ps, con);
        }

        return books;
    }
    
    
    
    public Book getBookById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String SELECT_BOOK_BY_ID_QUERY =
                "SELECT id, title, author, isbn, category, total_copies, available_copies "
                + "FROM book WHERE id = ?";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(SELECT_BOOK_BY_ID_QUERY);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                Book book = new Book();

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                book.setCategory(rs.getString("category"));
                book.setTotalCopies(rs.getInt("total_copies"));
                book.setAvailableCopies(rs.getInt("available_copies"));

                return book;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    public Book updateBook(Book book) {

        Connection con = null;
        PreparedStatement ps = null;

        final String UPDATE_BOOK_QUERY =
                "UPDATE book SET title = ?, author = ?, isbn = ?, category = ?, "
                + "total_copies = ?, available_copies = ? WHERE id = ?";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(UPDATE_BOOK_QUERY);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.setString(4, book.getCategory());
            ps.setInt(5, book.getTotalCopies());
            ps.setInt(6, book.getAvailableCopies());
            ps.setInt(7, book.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book updated successfully");
                return book;
            } else {
                System.out.println("Book could not be updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    public boolean deleteBook(int id) {

        Connection con = null;
        PreparedStatement ps = null;

        final String DELETE_BOOK_QUERY =
                "DELETE FROM book WHERE id = ?";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(DELETE_BOOK_QUERY);

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully");
                return true;
            } else {
                System.out.println("Book not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            CloseConnectionUtil.closeConnection(ps, con);
        }

        return false;
    }
    
    
    
    public List<Book> searchBooks(String keyword) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Book> books = new ArrayList<>();

        final String SEARCH_BOOK_QUERY =
                "SELECT id, title, author, isbn, category, total_copies, available_copies "
                + "FROM book "
                + "WHERE title LIKE ? OR author LIKE ? OR isbn LIKE ?";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(SEARCH_BOOK_QUERY);

            String searchKeyword = "%" + keyword + "%";

            ps.setString(1, searchKeyword);
            ps.setString(2, searchKeyword);
            ps.setString(3, searchKeyword);

            rs = ps.executeQuery();

            while (rs.next()) {

                Book book = new Book();

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                book.setCategory(rs.getString("category"));
                book.setTotalCopies(rs.getInt("total_copies"));
                book.setAvailableCopies(rs.getInt("available_copies"));

                books.add(book);
            }

            return books;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            CloseConnectionUtil.closeConnection(ps, con);
        }

        return books;
    }
}
