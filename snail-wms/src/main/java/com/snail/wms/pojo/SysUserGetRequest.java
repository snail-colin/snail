package com.snail.wms.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;
import java.util.List;

/**
 * @author colin
 * 2019/1/31
 */
public class SysUserGetRequest extends PageBaseRequest {

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="账号")
    private String account;

    @ApiModelProperty(value="状态,多个以(,)号分割")
    private List<Byte> status;

    @ApiModelProperty(value="开始时间,格式yyyyMMddHHmmss")
    private String beginTime;

    @ApiModelProperty(value="结束时间,格式yyyyMMddHHmmss")
    private String endTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<Byte> getStatus() {
        return status;
    }

    public void setStatus(List<Byte> status) {
        this.status = status;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", status=" + status +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
