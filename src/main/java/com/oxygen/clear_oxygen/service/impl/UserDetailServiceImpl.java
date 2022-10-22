package com.oxygen.clear_oxygen.service.impl;

import com.oxygen.clear_oxygen.PO.SysUser;
import com.oxygen.clear_oxygen.POJO.LoginUser;
import com.oxygen.clear_oxygen.dao.AuthorizeMapper;
import com.oxygen.clear_oxygen.dao.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private AuthorizeMapper authorizeMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = new SysUser();
        user.setUserName(username);

        SysUser sysUser = sysUserMapper.getSysUser(user);

        if (sysUser == null){
            throw new RuntimeException("用户名不存在");
        }

        log.info("username: " + sysUser.getUserName() + "  password: " + sysUser.getPassword());

        List<String> roles = authorizeMapper.getAllMenuByUserId(sysUser.getUserId());


        LoginUser loginUser = new LoginUser();
        loginUser.setUser(sysUser);
        loginUser.setPermissions(roles);
        return loginUser;
    }
}
