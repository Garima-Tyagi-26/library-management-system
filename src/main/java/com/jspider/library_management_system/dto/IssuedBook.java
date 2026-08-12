package com.jspider.library_management_system.dto;

import java.sql.Date;
import java.util.Objects;

public class IssuedBook {

    private int id;
    private int bookId;
    private int memberId;
    private Date issueDate;
    private Date dueDate;
    private Date returnDate;
    private double fineAmount;

    public IssuedBook() {
        super();
    }

    public IssuedBook(int id, int bookId, int memberId, Date issueDate, Date dueDate,
                       Date returnDate, double fineAmount) {
        super();
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public String toString() {
        return "IssuedBook [id=" + id
                + ", bookId=" + bookId
                + ", memberId=" + memberId
                + ", issueDate=" + issueDate
                + ", dueDate=" + dueDate
                + ", returnDate=" + returnDate
                + ", fineAmount=" + fineAmount + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, memberId, issueDate,
                dueDate, returnDate, fineAmount);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        IssuedBook other = (IssuedBook) obj;

        return id == other.id
                && bookId == other.bookId
                && memberId == other.memberId
                && Objects.equals(issueDate, other.issueDate)
                && Objects.equals(dueDate, other.dueDate)
                && Objects.equals(returnDate, other.returnDate)
                && Double.compare(fineAmount, other.fineAmount) == 0;
    }
}