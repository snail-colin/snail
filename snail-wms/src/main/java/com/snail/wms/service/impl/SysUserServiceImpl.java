package com.snail.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.snail.wms.common.PageRequest;
import com.snail.wms.common.Result;
import com.snail.wms.common.ResultType;
import com.snail.wms.dao.SysUserMapper;
import com.snail.wms.entity.SysUser;
import com.snail.wms.entity.SysUserExample;
import com.snail.wms.pojo.SysUserRequest;
import com.snail.wms.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author colin
 * 2019/1/28
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo<SysUser> getUserList(PageRequest<SysUserRequest> page) {
        SysUserExample example = new SysUserExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysUser> list = sysUserMapper.selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public Result<String> createUser(SysUser user) {
        Result<String> result = null;
        try {
            sysUserMapper.insertSelective(user);
            result = new Result<>("创建用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result<>(ResultType.error,null,"创建用户失败");
        }
        return result;
    }
}
