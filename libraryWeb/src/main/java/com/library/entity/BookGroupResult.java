package com.library.entity;

import org.bouncycastle.asn1.cms.PasswordRecipientInfo;

import java.util.Date;
import java.util.List;

public class BookGroupResult {

    private int sysNo;

    private String name;

    private String position;

    private int positionSysNo;

    private String author;

    private Date inDate;

    private List<BookSKUResult> skus;

    public int getSysNo() {
        return sysNo;
    }

    public void setSysNo(int sysNo) {
        this.sysNo = sysNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPositionSysNo() {
        return positionSysNo;
    }

    public void setPositionSysNo(int positionSysNo) {
        this.positionSysNo = positionSysNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public List<BookSKUResult> getSkus() {
        return skus;
    }

    public void setSkus(List<BookSKUResult> skus) {
        this.skus = skus;
    }
}
