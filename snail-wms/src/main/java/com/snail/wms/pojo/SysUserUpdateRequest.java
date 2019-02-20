package com.snail.wms.pojo;

import com.snail.wms.common.annotation.Length;
import com.snail.wms.common.annotation.NotEmpty;
import io.swagger.annotations.ApiModelProperty;

public class SysUserUpdateRequest {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "密码")
    @Length(max = 20)
    private String password;

    @ApiModelProperty(value = "姓名")
    @Length(max = 20)
    private String name;

    @ApiModelProperty(value = "状态")
    @Length(max = 20)
    private byte status;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SysUserUpdateRequest{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}