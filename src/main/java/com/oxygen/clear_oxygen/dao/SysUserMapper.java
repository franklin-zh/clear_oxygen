package com.oxygen.clear_oxygen.dao;

import com.oxygen.clear_oxygen.PO.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户 Mapper接口
 */
@Mapper
public interface SysUserMapper {

    SysUser getSysUser(SysUser sysUser);
}
