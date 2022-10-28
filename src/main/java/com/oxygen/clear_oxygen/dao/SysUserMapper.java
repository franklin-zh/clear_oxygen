package com.oxygen.clear_oxygen.dao;

import com.oxygen.clear_oxygen.PO.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户 Mapper接口
 */
@Mapper
public interface SysUserMapper {

    List<SysUser> getSysUser(SysUser sysUser);

    Boolean addSysUser(SysUser sysUser);

    int setSysUser(SysUser sysUser);

    boolean delSysUser(@Param("userId") long userId);
}
