<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.jspider.library_management_system.dto.Member" %>

<%
    Member searchedMember =
            (Member) request.getAttribute("member");

    List<Member> members =
            (List<Member>) request.getAttribute("members");
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Members - Library Management System</title>

    <!-- Bootstrap -->
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


        /* Search card */

        .search-card {
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


            <a href="${pageContext.request.contextPath}/add-book">

                <i class="bi bi-book me-2"></i>
                Books

            </a>


            <a href="${pageContext.request.contextPath}/members"
               class="active">

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

                        <i class="bi bi-people"></i>
                        Members

                    </h2>


                    <p class="page-description mb-0">

                        Manage registered library members.

                    </p>

                </div>


                <a
                    href="add-member.jsp"
                    class="btn btn-primary">

                    <i class="bi bi-person-plus me-1"></i>
                    Add Member

                </a>

            </div>



            <!-- ================= SEARCH ================= -->

            <div class="search-card shadow-sm mb-4">


                <form action="search-member"
                      method="get">


                    <label class="form-label fw-semibold">

                        Search Member

                    </label>


                    <div class="row g-2">


                        <div class="col-md-8">

                            <input
                                type="number"
                                name="id"
                                class="form-control"
                                placeholder="Enter Member ID"
                                required>

                        </div>


                        <div class="col-md-4 d-flex gap-2">

                            <button
                                type="submit"
                                class="btn btn-primary">

                                <i class="bi bi-search me-1"></i>
                                Search

                            </button>


                            <a
                                href="${pageContext.request.contextPath}/members"
                                class="btn btn-outline-secondary">

                                View All

                            </a>

                        </div>

                    </div>

                </form>

            </div>



            <!-- ================================================= -->
            <!-- SEARCH RESULT -->
            <!-- ================================================= -->

            <%
                if (searchedMember != null) {
            %>


            <div class="table-card shadow-sm mb-4">


                <div class="p-3 border-bottom">

                    <h5 class="mb-0">

                        <i class="bi bi-person-check me-2"></i>
                        Search Result

                    </h5>

                </div>


                <div class="table-responsive">


                    <table class="table table-hover">

                        <thead>

                            <tr>

                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Membership Date</th>
                                <th>Username</th>
                                <th>Action</th>

                            </tr>

                        </thead>


                        <tbody>

                            <tr>

                                <td>
                                    <%= searchedMember.getId() %>
                                </td>

                                <td>
                                    <strong>
                                        <%= searchedMember.getName() %>
                                    </strong>
                                </td>

                                <td>
                                    <%= searchedMember.getEmail() %>
                                </td>

                                <td>
                                    <%= searchedMember.getPhone() %>
                                </td>

                                <td>
                                    <%= searchedMember.getAddress() %>
                                </td>

                                <td>
                                    <%= searchedMember.getMembershipDate() %>
                                </td>

                                <td>
                                    <%= searchedMember.getUsername() %>
                                </td>


                                <td>

                                    <a
                                        href="edit-member?id=<%= searchedMember.getId() %>"
                                        class="btn btn-sm btn-outline-primary">

                                        <i class="bi bi-pencil"></i>
                                        Edit

                                    </a>

                                </td>

                            </tr>

                        </tbody>

                    </table>

                </div>

            </div>


            <%
                }
            %>



            <!-- ================================================= -->
            <!-- ALL MEMBERS -->
            <!-- ================================================= -->

            <%
                if (searchedMember == null) {
            %>


            <div class="table-card shadow-sm">


                <div class="p-3 border-bottom">

                    <h5 class="mb-0">

                        <i class="bi bi-people me-2"></i>
                        All Members

                    </h5>

                </div>


                <div class="table-responsive">


                    <table class="table table-hover">

                        <thead>

                            <tr>

                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Membership Date</th>
                                <th>Username</th>
                                <th>Action</th>

                            </tr>

                        </thead>


                        <tbody>


                        <%
                            if (members != null && !members.isEmpty()) {

                                for (Member member : members) {
                        %>


                            <tr>

                                <td>
                                    <%= member.getId() %>
                                </td>

                                <td>

                                    <strong>
                                        <%= member.getName() %>
                                    </strong>

                                </td>

                                <td>
                                    <%= member.getEmail() %>
                                </td>

                                <td>
                                    <%= member.getPhone() %>
                                </td>

                                <td>
                                    <%= member.getAddress() %>
                                </td>

                                <td>
                                    <%= member.getMembershipDate() %>
                                </td>

                                <td>
                                    <%= member.getUsername() %>
                                </td>


                                <!-- Actions -->

                                <td>

                                    <div class="d-flex gap-2">


                                        <a
                                            href="edit-member?id=<%= member.getId() %>"
                                            class="btn btn-sm btn-outline-primary">

                                            <i class="bi bi-pencil"></i>
                                            Edit

                                        </a>


                                        <form action="delete-member" method="post" class="d-inline">

                                        <input
                                          type="hidden"
                                          name="id"
                                          value="<%= member.getId() %>">

                                        <button
                                         type="submit"
                                         class="btn btn-sm btn-outline-danger"
                                         onclick="return confirm('Are you sure you want to delete this member?');">

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
                                    colspan="8"
                                    class="text-center py-4 text-muted">

                                    <i class="bi bi-people fs-3 d-block mb-2"></i>

                                    No members found.

                                </td>

                            </tr>


                        <%
                            }
                        %>


                        </tbody>

                    </table>

                </div>

            </div>


            <%
                }
            %>


        </div>

    </div>

</div>


</body>

</html>