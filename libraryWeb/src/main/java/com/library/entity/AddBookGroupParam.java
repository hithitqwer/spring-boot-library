package com.library.entity;

import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;
import sun.awt.SunHints;

import java.util.List;

public class AddBookGroupParam {

    @ApiModelProperty(hidden = true)
    private int sysNo;

    private String name;

    private String author;

    private int position;

    @ApiModelProperty(hidden = true)
    private int inUser;

    private List<String> bookIdList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<String> getBookIdList() {
        return bookIdList;
    }

    public void setBookIdList(List<String> bookIdList) {
        this.bookIdList = bookIdList;
    }

    public int getSysNo() {
        return sysNo;
    }

    public void setSysNo(int sysNo) {
        this.sysNo = sysNo;
    }

    public int getInUser() {
        return inUser;
    }

    public void setInUser(int inUser) {
        this.inUser = inUser;
    }
}
