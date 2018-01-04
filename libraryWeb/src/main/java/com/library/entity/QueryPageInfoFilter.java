package com.library.entity;

import io.swagger.annotations.ApiModelProperty;

public class QueryPageInfoFilter {

    private int pageSize;

    private int pageIndex;

    //用于翻页查询的时候用,不暴露给外面
    @ApiModelProperty(hidden = true)
    private int pageLimitStart;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void pageLimitStart() {
        this.pageLimitStart = (this.pageIndex-1)*this.pageSize;
    }
}
