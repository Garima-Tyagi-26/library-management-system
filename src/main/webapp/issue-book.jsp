<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Issue Book</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        h1 {
            text-align: center;
        }

        form {
            width: 400px;
            margin: auto;
            padding: 25px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        label {
            display: block;
            margin-top: 15px;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        button {
            margin-top: 20px;
            width: 100%;
            padding: 10px;
            cursor: pointer;
        }

        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }

    </style>

</head>

<body>

    <h1>Issue Book</h1>

    <%
        String error = request.getParameter("error");

        if ("true".equals(error)) {
    %>

        <p class="error">
            Book could not be issued. Please check the Book ID,
            Member ID, and book availability.
        </p>

    <%
        }
    %>

    <form action="issue-book" method="post">

        <label for="bookId">
            Book ID:
        </label>

        <input type="number"
               id="bookId"
               name="bookId"
               required>


        <label for="memberId">
            Member ID:
        </label>

        <input type="number"
               id="memberId"
               name="memberId"
               required>


        <button type="submit">
            Issue Book
        </button>

    </form>

</body>
</html>