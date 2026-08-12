<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.jspider.library_management_system.dto.IssuedBook" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Issued Books</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 30px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        .active {
            color: green;
            font-weight: bold;
        }

        .returned {
            color: blue;
            font-weight: bold;
        }

        .fine {
            color: red;
            font-weight: bold;
        }

    </style>

</head>

<body>

    <h1>Issued Books</h1>

    <table>

        <tr>

            <th>Issue ID</th>
            <th>Book ID</th>
            <th>Member ID</th>
            <th>Issue Date</th>
            <th>Due Date</th>
            <th>Return Date</th>
            <th>Fine Amount</th>
            <th>Status</th>

        </tr>

        <%
            List<IssuedBook> issuedBooks =
                    (List<IssuedBook>) request.getAttribute("issuedBooks");

            if (issuedBooks != null && !issuedBooks.isEmpty()) {

                for (IssuedBook issuedBook : issuedBooks) {
        %>

        <tr>

            <td>
                <%= issuedBook.getId() %>
            </td>

            <td>
                <%= issuedBook.getBookId() %>
            </td>

            <td>
                <%= issuedBook.getMemberId() %>
            </td>

            <td>
                <%= issuedBook.getIssueDate() %>
            </td>

            <td>
                <%= issuedBook.getDueDate() %>
            </td>

            <td>

                <%
                    if (issuedBook.getReturnDate() != null) {
                %>

                    <%= issuedBook.getReturnDate() %>

                <%
                    } else {
                %>

                    Not Returned

                <%
                    }
                %>

            </td>

            <td>

                <span class="fine">
                    ₹<%= issuedBook.getFineAmount() %>
                </span>

            </td>

            <td>

                <%
                    if (issuedBook.getReturnDate() == null) {
                %>

                    <span class="active">
                        Issued
                    </span>

                <%
                    } else {
                %>

                    <span class="returned">
                        Returned
                    </span>

                <%
                    }
                %>

            </td>

        </tr>

        <%
                }

            } else {
        %>

        <tr>

            <td colspan="8">
                No issued book records found.
            </td>

        </tr>

        <%
            }
        %>

    </table>

</body>

</html>