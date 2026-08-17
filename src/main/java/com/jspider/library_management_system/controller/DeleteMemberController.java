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
        protected void doPost(HttpServletRequest req,
                HttpServletResponse resp)
                throws ServletException, IOException {

            int id = Integer.parseInt(req.getParameter("id"));

            boolean deleted = memberService.deleteMember(id);

            if (deleted) {

                resp.sendRedirect("members");

            } else {

                resp.sendRedirect("members?error=delete");
            }
      }
        
}
