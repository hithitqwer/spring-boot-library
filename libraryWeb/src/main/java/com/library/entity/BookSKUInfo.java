package com.library.entity;

import java.util.Date;

public class BookSKUInfo {

    private int sysNo;

    private String bookId;

    private boolean borrowed;

    private int borrowUserSysNo;

    private String borrowUserName;

    private int status;

    private int groupSysNo;

    private String name;

    private String author;

    private Date inDate;

    public int getSysNo() {
        return sysNo;
    }

    public void setSysNo(int sysNo) {
        this.sysNo = sysNo;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getBorrowUserSysNo() {
        return borrowUserSysNo;
    }

    public void setBorrowUserSysNo(int borrowUserSysNo) {
        this.borrowUserSysNo = borrowUserSysNo;
    }

    public String getBorrowUserName() {
        return borrowUserName;
    }

    public void setBorrowUserName(String borrowUserName) {
        this.borrowUserName = borrowUserName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGroupSysNo() {
        return groupSysNo;
    }

    public void setGroupSysNo(int groupSysNo) {
        this.groupSysNo = groupSysNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
