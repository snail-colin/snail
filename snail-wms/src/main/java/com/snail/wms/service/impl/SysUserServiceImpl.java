package com.snail.wms.service.impl;

import com.github.pagehelper.PageInfo;
import com.snail.wms.common.*;
import com.snail.wms.common.enums.CodeEnum;
import com.snail.wms.dao.SysUserMapper;
import com.snail.wms.entity.SysUser;
import com.snail.wms.entity.SysUserExample;
import com.snail.wms.pojo.SysUserCreateRequest;
import com.snail.wms.pojo.SysUserGetRequest;
import com.snail.wms.pojo.SysUserUpdateRequest;
import com.snail.wms.service.ISysUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
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
    public PageInfo<SysUser> getUserList(PageRequest<SysUserGetRequest> page) {
        List<SysUser> list = sysUserMapper.selectByExample(bulidExample(page));
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 构建查询条件
     *
     * @param page
     * @return
     */
    private SysUserExample bulidExample(PageRequest<SysUserGetRequest> page) {
        if (page.getParams() == null)
            return null;
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        SysUserGetRequest entity = page.getParams();

        if (StringUtils.isNotBlank(entity.getName()))
            criteria.andNameLike(entity.getName());

        if (StringUtils.isNotBlank(entity.getAccount()))
            criteria.andAccountLike(entity.getAccount());

        if (StringUtils.isNotBlank(entity.getBeginTime()))
            criteria.andUpdateTimeGreaterThan(entity.getBeginTime());

        if (StringUtils.isNotBlank(entity.getEndTime()))
            criteria.andUpdateTimeLessThanOrEqualTo(entity.getEndTime());

        if (entity.getStatus() != null && !entity.getStatus().isEmpty())
            criteria.andStatusIn(entity.getStatus());

        return example;
    }

    @Override
    public Result<String> createUser(SysUserCreateRequest _user) {
        Result<String> result = null;
        SysUser user = null;
        try {
            //属性复制
            user = BulidEntityUtil.bulidEntity(SysUser.class, ConvertorUtil.pojo2Json(_user));
            //校验
            SysUserExample example = new SysUserExample();
            SysUserExample.Criteria criteria = example.createCriteria();
            criteria.andAccountEqualTo(user.getAccount());
            int count = sysUserMapper.countByExample(example);
            if (count > 0) {
                result = new Result<>(ResultType.error, CodeEnum.N00010.getCode(), CodeEnum.N00010.getMsg());
                return result;
            }
            sysUserMapper.insertSelective(bulidUser(user));
            result = new Result<>("创建用户成功");
        } catch (IntrospectionException e) {
            return new Result<>(ResultType.error, CodeEnum.N00004.getCode(), CodeEnum.N00004.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result<>(ResultType.error, CodeEnum.N00001.getCode(), "创建用户失败");
        }
        return result;
    }

    @Override
    public Result<String> updateUser(SysUserUpdateRequest _user) {
        Result<String> result = null;
        SysUser user = null;
        try {
            //校验
            user = sysUserMapper.selectByPrimaryKey(_user.getId());
            if (user ==  null) {
                result = new Result<>(ResultType.error, CodeEnum.N00011.getCode(), CodeEnum.N00011.getMsg());
                return result;
            }
            String now = DateUtil.getNowDate2yyyyMMddHHmmss();
            //属性复制
            SysUser tempUser = BulidEntityUtil.bulidEntity(SysUser.class,ConvertorUtil.json2map(ConvertorUtil.pojo2Json(_user)));
            BulidEntityUtil.bulidEntity(user,tempUser,new String[]{"id","account","createTime"});
            user.setUpdateTime(now);
            sysUserMapper.updateByPrimaryKeySelective(user);
            result = new Result<>("更新用户成功");
        } catch (IntrospectionException e) {
            return new Result<>(ResultType.error, CodeEnum.N00004.getCode(), CodeEnum.N00004.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result<>(ResultType.error, CodeEnum.N00001.getCode(), "更新用户失败");
        }
        return result;
    }

    @Override
    public Result<String> delUser(Integer id) {
        Result<String> result = null;
        try {
            sysUserMapper.deleteByPrimaryKey(id);
            result = new Result<>("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result<>(ResultType.error, CodeEnum.N00001.getCode(), CodeEnum.N00001.getMsg());
        }
        return result;
    }

    /**
     * 构建用户信息
     *
     * @param user
     * @return
     */
    private SysUser bulidUser(SysUser user) {
        String now = DateUtil.getNowDate2yyyyMMddHHmmss();
        String salt = RandomStringUtils.randomAlphabetic(6).toLowerCase();
        //TODO 需要与密码做加密处理
        user.setSalt(salt);
        user.setCreateTime(now);
        user.setUpdateTime(now);
        return user;
    }
}
