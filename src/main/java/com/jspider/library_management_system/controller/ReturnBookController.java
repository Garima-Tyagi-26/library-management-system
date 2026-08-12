package com.jspider.library_management_system.controller;

import java.io.IOException;

import com.jspider.library_management_system.service.IssuedBookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/return-book")
public class ReturnBookController extends HttpServlet {

    private IssuedBookService issuedBookService =
            new IssuedBookService();

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        int issueId =
                Integer.parseInt(req.getParameter("issueId"));

        boolean returned =
                issuedBookService.returnBook(issueId);

        if (returned) {

            resp.sendRedirect("books.jsp");

        } else {

            resp.sendRedirect(
                    "return-book.jsp?error=true");
        }
    }
}
