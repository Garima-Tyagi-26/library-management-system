<%@ page import="java.util.List" %>
<%@ page import="com.jspider.library_management_system.dto.Book" %>

<%
    List<Book> books =
            (List<Book>) request.getAttribute("books");

    String keyword =
            (String) request.getAttribute("keyword");
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Books - Library Management System</title>

    <!-- Bootstrap 5 -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <style>

        body {
            background-color: #f5f6fa;
            font-family: Arial, sans-serif;
        }

        /* Navbar */

        .navbar {
            height: 65px;
        }

        .navbar-brand {
            font-weight: 600;
            font-size: 20px;
        }

        /* Sidebar */

        .sidebar {
            min-height: calc(100vh - 65px);
            background-color: #212529;
            padding-top: 20px;
        }

        .sidebar a {
            color: #ced4da;
            text-decoration: none;
            display: block;
            padding: 12px 20px;
            margin: 4px 10px;
            border-radius: 6px;
        }

        .sidebar a:hover {
            background-color: #343a40;
            color: white;
        }

        .sidebar a.active {
            background-color: #0d6efd;
            color: white;
        }

        /* Main content */

        .main-content {
            padding: 30px;
        }

        .page-title {
            font-weight: 600;
        }

        .page-description {
            color: #6c757d;
        }

        /* Search */

        .search-box {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
        }

        /* Table */

        .table-card {
            background-color: white;
            border-radius: 10px;
            overflow: hidden;
        }

        .table {
            margin-bottom: 0;
        }

        .table th {
            background-color: #212529;
            color: white;
            white-space: nowrap;
        }

        .table td {
            vertical-align: middle;
        }

        /* Availability badges */

        .availability-badge {
            font-size: 13px;
        }

    </style>

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar navbar-dark bg-dark">

    <div class="container-fluid">

        <a class="navbar-brand"
           href="${pageContext.request.contextPath}/dashboard">

            <i class="bi bi-book"></i>
            Library Management System

        </a>

        <div class="text-white">

            <span class="me-3">
                <i class="bi bi-person-circle"></i>
                Librarian
            </span>

            <a
                href="${pageContext.request.contextPath}/logout"
                class="btn btn-outline-light btn-sm">

                Logout

            </a>

        </div>

    </div>

</nav>


<!-- ================= MAIN LAYOUT ================= -->

<div class="container-fluid">

    <div class="row">

        <!-- ================= SIDEBAR ================= -->

        <div class="col-md-2 sidebar">

            <a href="${pageContext.request.contextPath}/dashboard">

                <i class="bi bi-speedometer2 me-2"></i>
                Dashboard

            </a>

            <a href="${pageContext.request.contextPath}/add-book"
               class="active">

                <i class="bi bi-book me-2"></i>
                Books

            </a>

            <a href="${pageContext.request.contextPath}/members">

                <i class="bi bi-people me-2"></i>
                Members

            </a>

            <a href="issue-book.jsp">

                <i class="bi bi-journal-plus me-2"></i>
                Issue Book

            </a>

            <a href="return-book.jsp">

                <i class="bi bi-arrow-return-left me-2"></i>
                Return Book

            </a>

            <a href="${pageContext.request.contextPath}/issued-books">

                <i class="bi bi-journal-text me-2"></i>
                Issued Books

            </a>

        </div>


        <!-- ================= CONTENT ================= -->

        <div class="col-md-10 main-content">

            <!-- Page heading -->

            <div class="d-flex justify-content-between align-items-center mb-4">

                <div>

                    <h2 class="page-title">
                        <i class="bi bi-book"></i>
                        Books
                    </h2>

                    <p class="page-description mb-0">
                        Manage books available in the library.
                    </p>

                </div>

                <a href="add-book.jsp"
                   class="btn btn-primary">

                    <i class="bi bi-plus-circle me-1"></i>
                    Add New Book

                </a>

            </div>


            <!-- ================= SEARCH ================= -->

            <div class="search-box shadow-sm mb-4">

                <form action="add-book"
                      method="get">

                    <div class="row g-2">

                        <div class="col-md-9">

                            <input
                                type="text"
                                name="keyword"
                                class="form-control"
                                placeholder="Search by title, author or ISBN"
                                value="<%= keyword != null ? keyword : "" %>">

                        </div>

                        <div class="col-md-3 d-flex gap-2">

                            <button
                                type="submit"
                                class="btn btn-primary">

                                <i class="bi bi-search me-1"></i>
                                Search

                            </button>

                            <a
                                href="add-book"
                                class="btn btn-outline-secondary">

                                Clear

                            </a>

                        </div>

                    </div>

                </form>

            </div>


            <!-- ================= TABLE ================= -->

            <div class="table-card shadow-sm">

                <div class="table-responsive">

                    <table class="table table-hover align-middle">

                        <thead>

                            <tr>

                                <th>ID</th>
                                <th>Title</th>
                                <th>Author</th>
                                <th>ISBN</th>
                                <th>Category</th>
                                <th>Total</th>
                                <th>Available</th>
                                <th>Status</th>
                                <th>Actions</th>

                            </tr>

                        </thead>

                        <tbody>

                        <%
                            if (books != null && !books.isEmpty()) {

                                for (Book book : books) {
                        %>

                            <tr>

                                <td>
                                    <%= book.getId() %>
                                </td>

                                <td>
                                    <strong>
                                        <%= book.getTitle() %>
                                    </strong>
                                </td>

                                <td>
                                    <%= book.getAuthor() %>
                                </td>

                                <td>
                                    <%= book.getIsbn() %>
                                </td>

                                <td>
                                    <%= book.getCategory() %>
                                </td>

                                <td>
                                    <%= book.getTotalCopies() %>
                                </td>

                                <td>
                                    <%= book.getAvailableCopies() %>
                                </td>


                                <!-- Availability -->

                                <td>

                                    <%
                                        if (book.getAvailableCopies() > 0) {
                                    %>

                                        <span class="badge bg-success availability-badge">
                                            Available
                                        </span>

                                    <%
                                        } else {
                                    %>

                                        <span class="badge bg-danger availability-badge">
                                            Not Available
                                        </span>

                                    <%
                                        }
                                    %>

                                </td>


                                <!-- Actions -->

                                <td>

                                    <div class="d-flex gap-2">

                                        <a
                                            href="update-book?id=<%= book.getId() %>"
                                            class="btn btn-sm btn-outline-primary">

                                            <i class="bi bi-pencil"></i>
                                            Edit

                                        </a>


                                        <form
                                            action="delete-book"
                                            method="post"
                                            class="d-inline">

                                            <input
                                                type="hidden"
                                                name="id"
                                                value="<%= book.getId() %>">

                                            <button
                                                type="submit"
                                                class="btn btn-sm btn-outline-danger"
                                                onclick="return confirm('Are you sure you want to delete this book?');">

                                                <i class="bi bi-trash"></i>
                                                Delete

                                            </button>

                                        </form>

                                    </div>

                                </td>

                            </tr>

                        <%
                                }

                            } else {
                        %>

                            <tr>

                                <td
                                    colspan="9"
                                    class="text-center py-4 text-muted">

                                    <i class="bi bi-book fs-3 d-block mb-2"></i>

                                    No books found.

                                </td>

                            </tr>

                        <%
                            }
                        %>

                        </tbody>

                    </table>

                </div>

            </div>

        </div>

    </div>

</div>


<!-- Bootstrap JS -->

<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>

</body>

</html>