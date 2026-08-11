<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.jspider.library_management_system.dto.Member" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Member</title>
</head>

<body>

    <h1>Update Member</h1>

    <%
        Member member = (Member) request.getAttribute("member");
    %>

    <form action="update-member" method="post">

        <!-- ID -->
        <input type="hidden" name="id"
               value="<%= member.getId() %>">

        <label>Name:</label>
        <input type="text" name="name"
               value="<%= member.getName() %>" required>

        <br><br>

        <label>Email:</label>
        <input type="email" name="email"
               value="<%= member.getEmail() %>" required>

        <br><br>

        <label>Phone:</label>
        <input type="text" name="phone"
               value="<%= member.getPhone() %>" required>

        <br><br>

        <label>Address:</label>
        <input type="text" name="address"
               value="<%= member.getAddress() %>">

        <br><br>

        <label>Membership Date:</label>
        <input type="date" name="membershipDate"
               value="<%= member.getMembershipDate() %>" required>

        <br><br>

        <label>Username:</label>
        <input type="text" name="username"
               value="<%= member.getUsername() %>" required>

        <br><br>

        <label>Password:</label>
        <input type="password" name="password"
               value="<%= member.getPassword() %>" required>

        <br><br>

        <button type="submit">Update Member</button>

    </form>

    <br>

    <a href="members">Back to Members</a>

</body>
</html>