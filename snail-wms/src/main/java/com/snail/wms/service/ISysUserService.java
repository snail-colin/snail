package com.snail.wms.service;

import com.github.pagehelper.PageInfo;
import com.snail.wms.common.PageRequest;
import com.snail.wms.common.Result;
import com.snail.wms.entity.SysUser;
import com.snail.wms.pojo.SysUserRequest;

/**
 * @author colin
 * 2019/1/28
 */
public interface ISysUserService {

    /**
     * 获取用户列表
     * @return
     */
    PageInfo<SysUser> getUserList(PageRequest<SysUserRequest> page);

    /**
     * 创建用户
     * @param user
     */
    Result<String> createUser(SysUser user);
}
