package com.library.entity;

import io.swagger.annotations.ApiParam;

/**
 * @create user 张聪
 * @create date
 * @edit user
 * @edit date
 * @desc 用于前台下拉框公共实体
 */
public class Position {

    private int sysNo;

    private String value;

    public int getSysNo() {
        return sysNo;
    }

    public void setSysNo(int sysNo) {
        this.sysNo = sysNo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
