package com.snail.wms.controller;

import com.github.pagehelper.PageInfo;
import com.snail.wms.common.*;
import com.snail.wms.common.enums.CodeEnum;
import com.snail.wms.entity.SysUser;
import com.snail.wms.pojo.SysUserCreateRequest;
import com.snail.wms.pojo.SysUserGetRequest;
import com.snail.wms.pojo.SysUserUpdateRequest;
import com.snail.wms.service.ISysUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.IntrospectionException;

/**
 * @author colin
 * 2019/1/28
 */
@Api(value = "用户管理信息", tags = "用户管理信息")
@RestController()
@RequestMapping("/api/sys")
public class UserController extends BaseController {

    @Autowired
    ISysUserService sysUserService;


    /**
     * 获取用户列表
     * @param request
     * @return
     */
    @ApiOperation(value = "获取用户列表接口", produces = "application/json")
    @GetMapping("/users")
    public PageInfo<SysUser> getUsers(SysUserGetRequest request) {
        PageRequest<SysUserGetRequest> page = new PageRequest<>(request.getPageNum(), request.getPageSize(), request);
        return sysUserService.getUserList(page);
    }

    /**
     * 创建用户
     *
     * @param user
     */
    @ApiOperation(value = "创建用户", produces = "application/json")
//    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    @PostMapping("/user")
    public Result<String> createUser(@RequestBody SysUserCreateRequest user) {
        try {
            checkRequest(user);
        } catch (BaseException e) {
            return new Result<>(ResultType.error, e.getCode(), e.getMsg());
        }
        return sysUserService.createUser(user);
    }


    /**
     * 更新用户
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户", produces = "application/json")
    @PutMapping("/user/{id}")
    public Result<String> updateUser(@PathVariable Integer id,@RequestBody SysUserUpdateRequest user) {
        try {
            checkRequest(user);
            user.setId(id);
        } catch (BaseException e) {
            return new Result<>(ResultType.error, e.getCode(), e.getMsg());
        }
        return sysUserService.updateUser(user);
    }


    /**
     * 删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", produces = "application/json")
    @DeleteMapping("/user/{id}")
    public Result<String> delUser(@PathVariable Integer id) {
        System.out.println("测试一下");
        return sysUserService.delUser(id);
    }

}
