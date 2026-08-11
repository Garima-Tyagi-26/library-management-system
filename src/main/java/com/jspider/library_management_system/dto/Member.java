package com.jspider.library_management_system.dto;

import java.sql.Date;
import java.util.Objects;

public class Member {

    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private Date membershipDate;
    private String username;
    private String password;

    public Member() {
    }

    public Member(int id, String name, String email, String phone, String address, Date membershipDate,
            String username, String password) {

     this.id = id;
     this.name = name;
     this.email = email;
     this.phone = phone;
     this.address = address;
     this.membershipDate = membershipDate;
     this.username = username;
     this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Member [id=" + id
                + ", name=" + name
                + ", email=" + email
                + ", phone=" + phone
                + ", address=" + address
                + ", membershipDate=" + membershipDate
                + ", username=" + username
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, address,
                membershipDate, username, password);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Member other = (Member) obj;

        return id == other.id
                && Objects.equals(name, other.name)
                && Objects.equals(email, other.email)
                && Objects.equals(phone, other.phone)
                && Objects.equals(address, other.address)
                && Objects.equals(membershipDate, other.membershipDate)
                && Objects.equals(username, other.username)
                && Objects.equals(password, other.password);
    }
}