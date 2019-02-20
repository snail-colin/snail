package com.snail.wms.service;

import com.github.pagehelper.PageInfo;
import com.snail.wms.common.PageRequest;
import com.snail.wms.common.Result;
import com.snail.wms.entity.SysUser;
import com.snail.wms.pojo.SysUserCreateRequest;
import com.snail.wms.pojo.SysUserGetRequest;
import com.snail.wms.pojo.SysUserUpdateRequest;

/**
 * @author colin
 * 2019/1/28
 */
public interface ISysUserService {

    /**
     * 获取用户列表
     * @return
     */
    PageInfo<SysUser> getUserList(PageRequest<SysUserGetRequest> page);

    /**
     * 创建用户
     * @param user
     */
    Result<String> createUser(SysUserCreateRequest user);

    /**
     * 更新用户
     * @param user
     */
    Result<String> updateUser(SysUserUpdateRequest user);



    /**
     * 删除用户
     * @param id
     * @return
     */
    Result<String> delUser(Integer id);
}
