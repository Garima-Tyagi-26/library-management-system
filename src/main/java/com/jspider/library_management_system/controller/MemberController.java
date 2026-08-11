package com.jspider.library_management_system.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jspider.library_management_system.dto.Member;
import com.jspider.library_management_system.service.MemberService;

@WebServlet({"/add-member", "/members", "/search-member"})
public class MemberController extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String membershipDate = req.getParameter("membershipDate");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Date membershipDateValue = Date.valueOf(membershipDate);

        Member member = new Member();

        member.setName(name);
        member.setEmail(email);
        member.setPhone(phone);
        member.setAddress(address);
        member.setMembershipDate(membershipDateValue);
        member.setUsername(username);
        member.setPassword(password);

        Member insertedMember = memberService.insertMember(member);

        if (insertedMember != null) {

            resp.sendRedirect("members");

        } else {

            resp.sendRedirect("add-member.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getServletPath();

        if ("/members".equals(path)) {

            List<Member> members = memberService.getAllMembers();

            req.setAttribute("members", members);

            req.getRequestDispatcher("members.jsp").forward(req, resp);

        } else if ("/search-member".equals(path)) {

            String idParameter = req.getParameter("id");

            int id = Integer.parseInt(idParameter);

            Member member = memberService.getMemberById(id);

            req.setAttribute("member", member);

            req.getRequestDispatcher("members.jsp").forward(req, resp);
        }
    }
}
