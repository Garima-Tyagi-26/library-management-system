<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>

    <h1>Add New Book</h1>

    <form action="add-book" method="post">

        <label>Book Title:</label>
        <input type="text" name="title" required>
        <br><br>

        <label>Author:</label>
        <input type="text" name="author" required>
        <br><br>

        <label>ISBN:</label>
        <input type="text" name="isbn" required>
        <br><br>

        <label>Category:</label>
        <input type="text" name="category" required>
        <br><br>

        <label>Total Copies:</label>
        <input type="number" name="totalCopies" required>
        <br><br>

        <label>Available Copies:</label>
        <input type="number" name="availableCopies" required>
        <br><br>

        <button type="submit">Add Book</button>

    </form>

</body>
</html>