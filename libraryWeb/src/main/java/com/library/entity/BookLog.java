package com.library.entity;

import java.util.Date;

public class BookLog {

    private int bookSysNo;

    private int userSysNo;

    private Date borrowDate;

    private Date returnDate;

    private int status;

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBookSysNo() {
        return bookSysNo;
    }

    public void setBookSysNo(int bookSysNo) {
        this.bookSysNo = bookSysNo;
    }

    public int getUserSysNo() {
        return userSysNo;
    }

    public void setUserSysNo(int userSysNo) {
        this.userSysNo = userSysNo;
    }
}
