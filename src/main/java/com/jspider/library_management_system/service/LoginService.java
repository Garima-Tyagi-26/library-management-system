package com.jspider.library_management_system.service;

import com.jspider.library_management_system.dao.MemberDao;
import com.jspider.library_management_system.dto.Member;

public class LoginService {

    private MemberDao memberDao = new MemberDao();

    public Member login(String username, String password) {

        // 1. Check whether username exists
        Member member =
                memberDao.getMemberByUsername(username);

        if (member == null) {

            System.out.println("Username not found");

            return null;
        }

        // 2. Check password
        if (!member.getPassword().equals(password)) {

            System.out.println("Incorrect password");

            return null;
        }

        // 3. Login successful
        return member;
    }
}