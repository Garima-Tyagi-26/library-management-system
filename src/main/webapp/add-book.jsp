<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Add Book - Library Management System</title>

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


        /* Page heading */

        .page-title {
            font-weight: 600;
        }

        .page-description {
            color: #6c757d;
        }


        /* Form card */

        .form-card {
            background-color: white;
            border-radius: 10px;
            padding: 30px;
        }


        /* Form labels */

        .form-label {
            font-weight: 500;
        }


        /* Buttons */

        .form-actions {
            margin-top: 25px;
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

            <div class="mb-4">

                <h2 class="page-title">

                    <i class="bi bi-plus-circle"></i>
                    Add New Book

                </h2>


                <p class="page-description">

                    Add a new book to the library collection.

                </p>

            </div>



            <!-- ================= FORM ================= -->

            <div class="form-card shadow-sm">


                <form action="add-book"
                      method="post"
                      id="addBookForm">


                    <div class="row">


                        <!-- Book Title -->

                        <div class="col-md-6 mb-3">

                            <label class="form-label">

                                Book Title

                            </label>

                            <input
                                type="text"
                                name="title"
                                class="form-control"
                                placeholder="Enter book title"
                                required>

                        </div>



                        <!-- Author -->

                        <div class="col-md-6 mb-3">

                            <label class="form-label">

                                Author

                            </label>

                            <input
                                type="text"
                                name="author"
                                class="form-control"
                                placeholder="Enter author name"
                                required>

                        </div>



                        <!-- ISBN -->

                        <div class="col-md-6 mb-3">

                            <label class="form-label">

                                ISBN

                            </label>

                            <input
                                type="text"
                                name="isbn"
                                class="form-control"
                                placeholder="Enter ISBN"
                                required>

                        </div>



                        <!-- Category -->

                        <div class="col-md-6 mb-3">

                            <label class="form-label">

                                Category

                            </label>

                            <input
                                type="text"
                                name="category"
                                class="form-control"
                                placeholder="e.g. Programming, Fiction"
                                required>

                        </div>



                        <!-- Total Copies -->

                        <div class="col-md-6 mb-3">

                            <label class="form-label">

                                Total Copies

                            </label>

                            <input
                                type="number"
                                name="totalCopies"
                                id="totalCopies"
                                class="form-control"
                                min="1"
                                placeholder="Enter total copies"
                                required>

                        </div>



                        <!-- Available Copies -->

                        <div class="col-md-6 mb-3">

                            <label class="form-label">

                                Available Copies

                            </label>

                            <input
                                type="number"
                                name="availableCopies"
                                id="availableCopies"
                                class="form-control"
                                min="0"
                                placeholder="Enter available copies"
                                required>

                        </div>

                    </div>



                    <!-- Buttons -->

                    <div class="form-actions">

                        <button
                            type="submit"
                            class="btn btn-primary">

                            <i class="bi bi-plus-circle me-1"></i>
                            Add Book

                        </button>


                        <a
                            href="${pageContext.request.contextPath}/add-book"
                            class="btn btn-outline-secondary ms-2">

                            Cancel

                        </a>

                    </div>


                </form>

            </div>

        </div>

    </div>

</div>



<!-- ================= JAVASCRIPT VALIDATION ================= -->

<script>

    document.getElementById("addBookForm").addEventListener("submit", function(event) {

        const totalCopies =
            parseInt(document.getElementById("totalCopies").value);

        const availableCopies =
            parseInt(document.getElementById("availableCopies").value);


        if (totalCopies <= 0) {

            alert("Total copies must be greater than 0.");

            event.preventDefault();

            return;
        }


        if (availableCopies < 0) {

            alert("Available copies cannot be negative.");

            event.preventDefault();

            return;
        }


        if (availableCopies > totalCopies) {

            alert("Available copies cannot be greater than total copies.");

            event.preventDefault();

            return;
        }

    });

</script>


</body>

</html>