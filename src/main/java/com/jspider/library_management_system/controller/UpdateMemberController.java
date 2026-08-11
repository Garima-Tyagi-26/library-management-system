package com.jspider.library_management_system.controller;

import java.io.IOException;
import java.sql.Date;

import com.jspider.library_management_system.dto.Member;
import com.jspider.library_management_system.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/edit-member", "/update-member"})
public class UpdateMemberController extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParameter = req.getParameter("id");

        int id = Integer.parseInt(idParameter);

        Member member = memberService.getMemberById(id);

        req.setAttribute("member", member);

        req.getRequestDispatcher("update-member.jsp")
           .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String membershipDate = req.getParameter("membershipDate");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Date membershipDateValue = Date.valueOf(membershipDate);

        Member member = new Member();

        member.setId(id);
        member.setName(name);
        member.setEmail(email);
        member.setPhone(phone);
        member.setAddress(address);
        member.setMembershipDate(membershipDateValue);
        member.setUsername(username);
        member.setPassword(password);

        Member updatedMember = memberService.updateMember(member);

        if (updatedMember != null) {

            resp.sendRedirect("members");

        } else {

            resp.sendRedirect("members");
        }
    }
}