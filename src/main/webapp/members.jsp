<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.jspider.library_management_system.dto.Member" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member Management</title>
</head>

<body>

    <h1>Member Management</h1>

    <!-- Search Member -->

    <h2>Search Member</h2>

    <form action="search-member" method="get">

        <label>Enter Member ID:</label>

        <input type="number" name="id" required>

        <button type="submit">Search</button>

    </form>

    <br>

    <%
        Member searchedMember = (Member) request.getAttribute("member");

        if (searchedMember != null) {
    %>

        <!-- Search Result -->

        <h2>Search Result</h2>

        <table border="1">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Membership Date</th>
                <th>Username</th>
                <th>Action</th>
            </tr>

            <tr>

                <td><%= searchedMember.getId() %></td>
                <td><%= searchedMember.getName() %></td>
                <td><%= searchedMember.getEmail() %></td>
                <td><%= searchedMember.getPhone() %></td>
                <td><%= searchedMember.getAddress() %></td>
                <td><%= searchedMember.getMembershipDate() %></td>
                <td><%= searchedMember.getUsername() %></td>

            </tr>

        </table>

        <br>

        <a href="members">View All Members</a>

    <%
        } else {
    %>

        <!-- All Members -->

        <h2>All Members</h2>

        <table border="1">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Membership Date</th>
                <th>Username</th>
            </tr>

            <%
                List<Member> members = (List<Member>) request.getAttribute("members");

                if (members != null && !members.isEmpty()) {

                    for (Member member : members) {
            %>

            <tr>

                <td><%= member.getId() %></td>
                <td><%= member.getName() %></td>
                <td><%= member.getEmail() %></td>
                <td><%= member.getPhone() %></td>
                <td><%= member.getAddress() %></td>
                <td><%= member.getMembershipDate() %></td>
                <td><%= member.getUsername() %></td>

                <td>
                   <a href="edit-member?id=<%= member.getId() %>"> Edit </a>
                   <br>
                   <a href="delete-member?id=<%= member.getId() %>"   
                      onclick="return confirm('Are you sure you want to delete this member?');"> Delete </a>
                   
                </td>
                
            </tr>

            <%
                    }

                } else {
            %>

            <tr>
                <td colspan="7">No members found.</td>
            </tr>

            <%
                }
            %>

        </table>

    <%
        }
    %>

</body>
</html>