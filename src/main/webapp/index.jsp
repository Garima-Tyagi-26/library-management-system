<%@ page import="com.jspider.library_management_system.dto.Member" %>

<%
    Member loggedInMember =
            (Member) session.getAttribute("loggedInMember");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Management System</title>
</head>

<body>

    <h1>Library Management System</h1>

    <h2>Book Management</h2>

    <a href="add-book.jsp">Add New Book</a>

    <br><br>

    <a href="add-book">View All Books</a>
    
    <%
    if (loggedInMember != null) {
    %>
           <h3>Welcome, <%= loggedInMember.getName() %>!</h3>
           
           <br><br>

           <a href="${pageContext.request.contextPath}/logout">Logout</a>

    <%
    } else {
    %>
           <h3>No user is logged in.</h3>
    <%
    }
    %>

</body>
</html>