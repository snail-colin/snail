package com.snail.wms.common;

import io.swagger.annotations.ApiModel;

/**
 * @author colin
 * 2019/1/31
 */
public class PageRequest<R> {

    //页码
    private  int pageNum = 0;

    //每页数量
    private  int pageSize = 10;

    //请求参数
    private  R params;

    public PageRequest() {

    }

    public PageRequest(R params) {
        this.params = params;
    }

    public PageRequest(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.params = null;
    }

    public PageRequest(int pageNum, int pageSize, R params) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.params = params;
    }

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

    public R getParams() {
        return params;
    }

    public void setParams(R params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", params=" + params +
                '}';
    }
}
