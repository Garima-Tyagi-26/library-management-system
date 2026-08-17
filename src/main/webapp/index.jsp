<%@ page import="com.jspider.library_management_system.dto.Member" %>

<%
    Member loggedInMember =
            (Member) session.getAttribute("loggedInMember");
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Library Management System</title>

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

        .welcome-section {
            margin-bottom: 30px;
        }

        .welcome-section h2 {
            font-weight: 600;
        }

        .welcome-section p {
            color: #6c757d;
        }

        /* Dashboard cards */

        .dashboard-card {
            border: none;
            border-radius: 10px;
            transition: 0.2s;
        }

        .dashboard-card:hover {
            transform: translateY(-3px);
        }

        .dashboard-icon {
            font-size: 30px;
        }

        .dashboard-number {
            font-size: 28px;
            font-weight: 600;
        }

        /* Quick actions */

        .quick-action {
            border-radius: 8px;
            padding: 18px;
            text-decoration: none;
            display: block;
            transition: 0.2s;
        }

        .quick-action:hover {
            transform: translateY(-2px);
        }

    </style>

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar navbar-dark bg-dark">

    <div class="container-fluid">

        <span class="navbar-brand">
            <i class="bi bi-book"></i>
            Library Management System
        </span>

        <div class="text-white">

            <%
                if (loggedInMember != null) {
            %>

                <span class="me-3">
                    <i class="bi bi-person-circle"></i>
                    <%= loggedInMember.getName() %>
                </span>

                <a
                    href="${pageContext.request.contextPath}/logout"
                    class="btn btn-outline-light btn-sm">
                    Logout
                </a>

            <%
                }
            %>

        </div>

    </div>

</nav>

<!-- ================= MAIN LAYOUT ================= -->

<div class="container-fluid">

    <div class="row">

        <!-- ================= SIDEBAR ================= -->

        <div class="col-md-2 sidebar">

            <a href="dashboard" class="active">
               Dashboard
            </a>

            <a href="add-book">
                <i class="bi bi-book me-2"></i>
                Books
            </a>

            <a href="members">
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

            <a href="issued-books">
                <i class="bi bi-journal-text me-2"></i>
                Issued Books
            </a>

        </div>


        <!-- ================= CONTENT ================= -->

        <div class="col-md-10 main-content">

            <!-- Welcome -->

            <div class="welcome-section">

                <h2>
                    Welcome,
                    <%= loggedInMember != null
                            ? loggedInMember.getName()
                            : "User" %>
                </h2>

                <p>
                    Here's an overview of your library management system.
                </p>

            </div>


            <!-- ================= DASHBOARD CARDS ================= -->

            <div class="row g-4 mb-4">

                <!-- Books -->

                <div class="col-md-4">

                    <div class="card dashboard-card shadow-sm">

                        <div class="card-body">

                            <div class="d-flex justify-content-between">

                                <div>
                                    <h6 class="text-muted">
                                        Total Books
                                    </h6>

                                     <div class="dashboard-number">
                                     <%= request.getAttribute("totalBooks") %>
                                     </div>
                                </div>

                                <div class="dashboard-icon text-primary">
                                    <i class="bi bi-book"></i>
                                </div>

                            </div>

                        </div>

                    </div>

                </div>


                <!-- Members -->

                <div class="col-md-4">

                    <div class="card dashboard-card shadow-sm">

                        <div class="card-body">

                            <div class="d-flex justify-content-between">

                                <div>
                                    <h6 class="text-muted">
                                        Total Members
                                    </h6>

                                     <div class="dashboard-number">
                                         <%= request.getAttribute("totalMembers") %>
                                    </div>
                                </div>

                                <div class="dashboard-icon text-success">
                                    <i class="bi bi-people"></i>
                                </div>

                            </div>

                        </div>

                    </div>

                </div>


                <!-- Issued Books -->

                <div class="col-md-4">

                    <div class="card dashboard-card shadow-sm">

                        <div class="card-body">

                            <div class="d-flex justify-content-between">

                                <div>
                                    <h6 class="text-muted">
                                        Issued Books
                                    </h6>

                                    <div class="dashboard-number">
                                      <%= request.getAttribute("totalIssuedBooks") %>
                                    </div>
                                </div>

                                <div class="dashboard-icon text-warning">
                                    <i class="bi bi-journal-text"></i>
                                </div>

                            </div>

                        </div>

                    </div>

                </div>

            </div>


            <!-- ================= QUICK ACTIONS ================= -->

            <div class="card shadow-sm border-0">

                <div class="card-body">

                    <h5 class="mb-4">
                        Quick Actions
                    </h5>

                    <div class="row g-3">

                        <div class="col-md-3">

                            <a href="add-book.jsp"
                               class="quick-action bg-primary text-white">

                                <i class="bi bi-plus-circle fs-4"></i>

                                <div class="mt-2 fw-semibold">
                                    Add Book
                                </div>

                            </a>

                        </div>


                        <div class="col-md-3">

                            <a href="add-member.jsp"
                               class="quick-action bg-success text-white">

                                <i class="bi bi-person-plus fs-4"></i>

                                <div class="mt-2 fw-semibold">
                                    Add Member
                                </div>

                            </a>

                        </div>


                        <div class="col-md-3">

                            <a href="issue-book.jsp"
                               class="quick-action bg-warning text-dark">

                                <i class="bi bi-journal-plus fs-4"></i>

                                <div class="mt-2 fw-semibold">
                                    Issue Book
                                </div>

                            </a>

                        </div>


                        <div class="col-md-3">

                            <a href="return-book.jsp"
                               class="quick-action bg-secondary text-white">

                                <i class="bi bi-arrow-return-left fs-4"></i>

                                <div class="mt-2 fw-semibold">
                                    Return Book
                                </div>

                            </a>

                        </div>

                    </div>

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

