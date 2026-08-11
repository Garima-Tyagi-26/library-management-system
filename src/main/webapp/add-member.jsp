<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Member</title>
</head>

<body>

    <h1>Add New Member</h1>

    <form action="add-member" method="post">

        <label>Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>Email:</label>
        <input type="email" name="email" required>
        <br><br>

        <label>Phone:</label>
        <input type="text" name="phone" required>
        <br><br>

        <label>Address:</label>
        <input type="text" name="address">
        <br><br>

        <label>Membership Date:</label>
        <input type="date" name="membershipDate" required>
        <br><br>

        <label>Username:</label>
        <input type="text" name="username" required>
        <br><br>

        <label>Password:</label>
        <input type="password" name="password" required>
        <br><br>

        <button type="submit">Add Member</button>

    </form>

</body>
</html>