package com.snail.wms.controller;

import com.github.pagehelper.PageInfo;
import com.snail.wms.common.PageRequest;
import com.snail.wms.common.Result;
import com.snail.wms.entity.SysUser;
import com.snail.wms.pojo.SysUserRequest;
import com.snail.wms.service.ISysUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author colin
 * 2019/1/28
 */
@Api(value = "用户管理信息", tags = "用户管理信息")
@RestController()
@RequestMapping("/api/sys/")
public class UserController extends BaseController {

    @Autowired
    ISysUserService sysUserService;


    /**
     * @return
     */
    @ApiOperation(value = "获取用户列表接口", produces = "application/json")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public PageInfo<SysUser> getUsers(SysUserRequest request) {
        PageRequest<SysUserRequest> page = new PageRequest<>(request.getPageNum(),request.getPageSize(),request);
        return sysUserService.getUserList(page);
    }

    /**
     * 创建用户
     *
     * @param user
     */
    @ApiOperation(value = "创建用户", produces = "application/json")
    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    public Result<String> createUser(@RequestBody SysUser user) {
        return sysUserService.createUser(user);
    }


}
