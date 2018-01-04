package com.library.entity;

import org.bouncycastle.asn1.cms.PasswordRecipientInfo;

import java.util.Date;
import java.util.List;

public class BookGroupInfo {

    private int sysNo;

    private String name;

    private String position;

    private int positionSysNo;

    private String author;

    private Date inDate;

    private int remainQty;

    private List<BookSKUInfo> skus;

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

    public List<BookSKUInfo> getSkus() {
        return skus;
    }

    public void setSkus(List<BookSKUInfo> skus) {
        this.skus = skus;
    }

    public int getRemainQty() {
        return remainQty;
    }

    public void setRemainQty(int remainQty) {
        this.remainQty = remainQty;
    }
}
