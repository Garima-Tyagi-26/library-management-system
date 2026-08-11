<%@ page import="com.jspider.library_management_system.dto.Book" %>

<%
    Book book = (Book) request.getAttribute("book");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
</head>

<body>

    <h1>Update Book</h1>

    <form action="update-book" method="post">

        <input type="hidden" name="id" value="<%= book.getId() %>">

        <label>Book Title:</label>
        <input type="text" name="title"
               value="<%= book.getTitle() %>" required>
        <br><br>

        <label>Author:</label>
        <input type="text" name="author"
               value="<%= book.getAuthor() %>" required>
        <br><br>

        <label>ISBN:</label>
        <input type="text" name="isbn"
               value="<%= book.getIsbn() %>" required>
        <br><br>

        <label>Category:</label>
        <input type="text" name="category"
               value="<%= book.getCategory() %>" required>
        <br><br>

        <label>Total Copies:</label>
        <input type="number" name="totalCopies"
               value="<%= book.getTotalCopies() %>" required>
        <br><br>

        <label>Available Copies:</label>
        <input type="number" name="availableCopies"
               value="<%= book.getAvailableCopies() %>" required>
        <br><br>

        <button type="submit">Update Book</button>

    </form>

    <br>

    <a href="add-book">Back to Books</a>

</body>
</html>