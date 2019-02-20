package com.snail.wms.pojo;

import com.snail.wms.common.annotation.Length;
import com.snail.wms.common.annotation.NotEmpty;
import io.swagger.annotations.ApiModelProperty;

public class SysUserCreateRequest {

    @ApiModelProperty(value = "账号",required = true)
    @NotEmpty
    @Length(max = 20)
    private String account;

    @ApiModelProperty(value = "密码",required = true)
    @NotEmpty
    @Length(max = 20)
    private String password;

    @ApiModelProperty(value = "姓名",required = true)
    @NotEmpty
    @Length(max = 20)
    private String name;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

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

    @Override
    public String toString() {
        return "SysUserCreateRequest{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}