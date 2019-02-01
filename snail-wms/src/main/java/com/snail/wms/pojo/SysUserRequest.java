package com.snail.wms.pojo;

import io.swagger.annotations.ApiModel;

/**
 * @author colin
 * 2019/1/31
 */
public class SysUserRequest extends BaseRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysUserRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
