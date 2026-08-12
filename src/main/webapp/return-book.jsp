<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Return Book</title>

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

    <h1>Return Book</h1>

    <%
        String error = request.getParameter("error");

        if ("true".equals(error)) {
    %>

        <p class="error">
            Book could not be returned.
            Please check the Issue ID.
        </p>

    <%
        }
    %>

    <form action="return-book" method="post">

        <label for="issueId"> Issue ID: </label>

        <input type="number" id="issueId" name="issueId" required>
        
        <button type="submit"> Return Book </button>

    </form>

</body>
</html>