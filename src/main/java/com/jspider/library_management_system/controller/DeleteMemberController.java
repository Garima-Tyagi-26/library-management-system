package com.jspider.library_management_system.controller;

import java.io.IOException;

import com.jspider.library_management_system.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-member")
public class DeleteMemberController extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParameter = req.getParameter("id");

        int id = Integer.parseInt(idParameter);

        boolean deleted = memberService.deleteMember(id);

        if (deleted) {

            System.out.println("Member deleted successfully");

        } else {

            System.out.println("Member not found");
        }

        resp.sendRedirect("members");
    }
}