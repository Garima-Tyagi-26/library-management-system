<%@ page import="java.util.List" %>
<%@ page import="com.jspider.library_management_system.dto.Book" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Books</title>
</head>

<body>

    <h1>Library Management System</h1>

    <h2>All Books</h2>
    
    <form action="add-book" method="get">

    <input type="text" name="keyword" placeholder="Search by title, author or ISBN"
      value="<%= request.getAttribute("keyword") != null ? request.getAttribute("keyword") : "" %>">

    <button type="submit">Search</button>
    <a href="add-book">Clear</a>
    </form> 
    
    <br>

    <a href="add-book.jsp">Add New Book</a>

    <br><br>

    <table border="1" cellpadding="10">

        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Category</th>
            <th>Total Copies</th>
            <th>Available Copies</th>
            <th>Action</th>
        </tr>

        <%
            List<Book> books = (List<Book>) request.getAttribute("books");

            if (books != null && !books.isEmpty()) {

                for (Book book : books) {
        %>

        <tr>
            <td><%= book.getId() %></td>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getIsbn() %></td>
            <td><%= book.getCategory() %></td>
            <td><%= book.getTotalCopies() %></td>
            <td><%= book.getAvailableCopies() %></td>
            
            <td>
            <a href="update-book?id=<%= book.getId() %>">Edit</a>
            <form action="delete-book" method="post" style="display:inline;">
            <input type="hidden" name="id" value="<%= book.getId() %>">
            <button type="submit" onclick="return confirm('Are you sure you want to delete this book?');">
                Delete
            </button>
            </form>
            </td>
        </tr>

        <%
                }

            } else {
        %>

        <tr>
            <td colspan="8">No books found.</td>
        </tr>

        <%
            }
        %>

    </table>

</body>
</html>