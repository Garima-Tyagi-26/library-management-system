package com.jspider.library_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}