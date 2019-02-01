package com.snail.wms.dao;

import com.snail.wms.entity.SysPermission;
import com.snail.wms.entity.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int countByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int deleteByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int insert(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int insertSelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    List<SysPermission> selectByExample(SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    SysPermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated Fri Feb 01 09:47:03 CST 2019
     */
    int updateByPrimaryKey(SysPermission record);
}