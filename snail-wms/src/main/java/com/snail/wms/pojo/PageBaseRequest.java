package com.snail.wms.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author colin
 * 2019/2/1
 */
public class PageBaseRequest {

    //页码
    @ApiModelProperty(value="页码")
    private  int pageNum = 0;

    //每页数量
    @ApiModelProperty(value="每页数量,默认10")
    private  int pageSize = 10;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageBaseRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
