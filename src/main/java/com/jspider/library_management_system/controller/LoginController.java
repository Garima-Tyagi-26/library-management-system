package com.jspider.library_management_system.controller;

import java.io.IOException;

import com.jspider.library_management_system.dto.Member;
import com.jspider.library_management_system.service.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	
    	System.out.println("========== LOGIN SERVLET CALLED ==========");

        String username = request.getParameter("username");

        String password = request.getParameter("password");

        Member member =
                loginService.login(username, password);

        if (member != null) {

            System.out.println("Login successful");

            // Create session
            HttpSession session = request.getSession();

            // Store logged-in member
            session.setAttribute("loggedInMember", member);

            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {

            System.out.println("Invalid username or password");

            response.sendRedirect("login.jsp?error=true");
        }
    }
}