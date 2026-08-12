package com.jspider.library_management_system.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.library_management_system.connection.ConnectionFactory;
import com.jspider.library_management_system.dto.IssuedBook;
import com.jspider.library_management_system.util.CloseConnectionUtil;

public class IssuedBookDao {

    public IssuedBook issueBook(IssuedBook issuedBook) {

        Connection con = null;
        PreparedStatement ps = null;

        final String INSERT_QUERY =
                "INSERT INTO issued_book "
                + "(BOOK_ID, MEMBER_ID, ISSUE_DATE, DUE_DATE, FINE_AMOUNT) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(
                    INSERT_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, issuedBook.getBookId());
            ps.setInt(2, issuedBook.getMemberId());
            ps.setDate(3, issuedBook.getIssueDate());
            ps.setDate(4, issuedBook.getDueDate());
            ps.setDouble(5, issuedBook.getFineAmount());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {

                var rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    issuedBook.setId(rs.getInt(1));
                }

                System.out.println("Book issued successfully");

                return issuedBook;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    
    public IssuedBook getActiveIssueByBookId(int bookId) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String SELECT_ACTIVE_ISSUE_QUERY =
                "SELECT id, book_id, member_id, issue_date, due_date, "
                + "return_date, fine_amount "
                + "FROM issued_book "
                + "WHERE book_id = ? AND return_date IS NULL";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(SELECT_ACTIVE_ISSUE_QUERY);

            ps.setInt(1, bookId);

            rs = ps.executeQuery();

            if (rs.next()) {

                IssuedBook issuedBook = new IssuedBook();

                issuedBook.setId(rs.getInt("id"));
                issuedBook.setBookId(rs.getInt("book_id"));
                issuedBook.setMemberId(rs.getInt("member_id"));
                issuedBook.setIssueDate(rs.getDate("issue_date"));
                issuedBook.setDueDate(rs.getDate("due_date"));
                issuedBook.setReturnDate(rs.getDate("return_date"));
                issuedBook.setFineAmount(rs.getDouble("fine_amount"));

                return issuedBook;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    
    public IssuedBook getActiveIssueById(int issueId) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String GET_ACTIVE_ISSUE_QUERY =
                "SELECT id, book_id, member_id, issue_date, due_date, "
                + "return_date, fine_amount "
                + "FROM issued_book "
                + "WHERE id = ? AND return_date IS NULL";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(GET_ACTIVE_ISSUE_QUERY);

            ps.setInt(1, issueId);

            rs = ps.executeQuery();

            if (rs.next()) {

                IssuedBook issuedBook = new IssuedBook();

                issuedBook.setId(rs.getInt("id"));
                issuedBook.setBookId(rs.getInt("book_id"));
                issuedBook.setMemberId(rs.getInt("member_id"));
                issuedBook.setIssueDate(rs.getDate("issue_date"));
                issuedBook.setDueDate(rs.getDate("due_date"));
                issuedBook.setReturnDate(rs.getDate("return_date"));
                issuedBook.setFineAmount(rs.getDouble("fine_amount"));

                return issuedBook;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    
    public boolean returnBook(int issueId, Date returnDate, double fineAmount) {

        Connection con = null;
        PreparedStatement ps = null;

        final String RETURN_BOOK_QUERY =
                "UPDATE issued_book "
                + "SET return_date = ?, fine_amount = ? "
                + "WHERE id = ? AND return_date IS NULL";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(RETURN_BOOK_QUERY);

            ps.setDate(1, returnDate);
            ps.setDouble(2, fineAmount);
            ps.setInt(3, issueId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("Book returned successfully");

                return true;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return false;
    }
    
    
    
    public List<IssuedBook> getAllIssuedBooks() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<IssuedBook> issuedBooks = new ArrayList<>();

        final String SELECT_ALL_ISSUED_BOOKS_QUERY =
                "SELECT id, book_id, member_id, issue_date, due_date, "
                + "return_date, fine_amount "
                + "FROM issued_book";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(
                    SELECT_ALL_ISSUED_BOOKS_QUERY
            );

            rs = ps.executeQuery();

            while (rs.next()) {

                IssuedBook issuedBook = new IssuedBook();

                issuedBook.setId(rs.getInt("id"));
                issuedBook.setBookId(rs.getInt("book_id"));
                issuedBook.setMemberId(rs.getInt("member_id"));
                issuedBook.setIssueDate(rs.getDate("issue_date"));
                issuedBook.setDueDate(rs.getDate("due_date"));
                issuedBook.setReturnDate(rs.getDate("return_date"));
                issuedBook.setFineAmount(rs.getDouble("fine_amount"));

                issuedBooks.add(issuedBook);
            }

            return issuedBooks;

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return issuedBooks;
    }
}