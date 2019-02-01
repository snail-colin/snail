package com.snail.wms.pojo;

/**
 * @author colin
 * 2019/2/1
 */
public class BaseRequest {

    //页码
    private  int pageNum = 0;

    //每页数量
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
        return "BaseRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
