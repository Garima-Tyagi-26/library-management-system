package com.jspider.library_management_system.service;

import java.util.List;

import com.jspider.library_management_system.dao.MemberDao;
import com.jspider.library_management_system.dto.Member;

public class MemberService {

    private MemberDao memberDao = new MemberDao();

    public Member insertMember(Member member) {

        return memberDao.insertMember(member);
    }
    
    public List<Member> getAllMembers() {

        return memberDao.getAllMembers();
    }
    
    public Member getMemberById(int id) {

        return memberDao.getMemberById(id);
    }
    
    public Member updateMember(Member member) {

        return memberDao.updateMember(member);
    }
    
    public boolean deleteMember(int id) {

        return memberDao.deleteMember(id);
    }
}