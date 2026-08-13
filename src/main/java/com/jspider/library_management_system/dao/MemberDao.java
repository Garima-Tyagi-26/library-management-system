package com.jspider.library_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.library_management_system.connection.ConnectionFactory;
import com.jspider.library_management_system.dto.Member;
import com.jspider.library_management_system.util.CloseConnectionUtil;

public class MemberDao {

    public Member insertMember(Member member) {

        Connection con = null;
        PreparedStatement ps = null;

        final String INSERT_MEMBER_QUERY =
                "INSERT INTO member "
                + "(name, email, phone, address, membership_date, username, password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(
                    INSERT_MEMBER_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());
            ps.setString(4, member.getAddress());
            ps.setDate(5, member.getMembershipDate());
            ps.setString(6, member.getUsername());
            ps.setString(7, member.getPassword());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {

                ResultSet generatedKeys = ps.getGeneratedKeys();

                if (generatedKeys.next()) {
                    member.setId(generatedKeys.getInt(1));
                }

                System.out.println("Member inserted successfully");

                return member;

            } else {

                System.out.println("Something went wrong");
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    
    public List<Member> getAllMembers() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Member> members = new ArrayList<>();

        final String SELECT_ALL_MEMBERS_QUERY =
                "SELECT * FROM member";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(SELECT_ALL_MEMBERS_QUERY);

            rs = ps.executeQuery();

            while (rs.next()) {

                Member member = new Member();

                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setAddress(rs.getString("address"));
                member.setMembershipDate(rs.getDate("membership_date"));
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));

                members.add(member);
            }

            return members;

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    public Member getMemberById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String SELECT_MEMBER_BY_ID_QUERY =
                "SELECT * FROM member WHERE id = ?";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(SELECT_MEMBER_BY_ID_QUERY);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                Member member = new Member();

                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setAddress(rs.getString("address"));
                member.setMembershipDate(rs.getDate("membership_date"));
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));

                return member;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    public Member updateMember(Member member) {

        Connection con = null;
        PreparedStatement ps = null;

        final String UPDATE_MEMBER_QUERY =
                "UPDATE member SET name = ?, email = ?, phone = ?, "
                + "address = ?, membership_date = ?, username = ?, password = ? "
                + "WHERE id = ?";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(UPDATE_MEMBER_QUERY);

            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());
            ps.setString(4, member.getAddress());
            ps.setDate(5, member.getMembershipDate());
            ps.setString(6, member.getUsername());
            ps.setString(7, member.getPassword());
            ps.setInt(8, member.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("Member updated successfully");

                return member;

            } else {

                System.out.println("Member not found or nothing was updated");
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
    
    
    
    public boolean deleteMember(int id) {

        Connection con = null;
        PreparedStatement ps = null;

        final String DELETE_MEMBER_QUERY =
                "DELETE FROM member WHERE id = ?";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(DELETE_MEMBER_QUERY);

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("Member deleted successfully");

                return true;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return false;
    }
    
    
    
    public Member getMemberByUsername(String username) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String GET_MEMBER_BY_USERNAME_QUERY =
                "SELECT * FROM member WHERE username = ?";

        try {

            con = ConnectionFactory.getConnectionFactory();

            ps = con.prepareStatement(GET_MEMBER_BY_USERNAME_QUERY);

            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next()) {

                Member member = new Member();

                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setAddress(rs.getString("address"));
                member.setMembershipDate(rs.getDate("membership_date"));
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));

                return member;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            CloseConnectionUtil.closeConnection(ps, con);
        }

        return null;
    }
}