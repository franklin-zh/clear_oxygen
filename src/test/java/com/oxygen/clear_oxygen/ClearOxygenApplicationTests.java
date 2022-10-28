package com.oxygen.clear_oxygen;

import com.oxygen.clear_oxygen.PO.SysUser;
import com.oxygen.clear_oxygen.dao.AuthorizeMapper;
import com.oxygen.clear_oxygen.dao.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class ClearOxygenApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthorizeMapper authorizeMapper;

    @Test
    void contextLoads() {
        SysUser user = new SysUser();
        List<SysUser> sysUser = sysUserMapper.getSysUser(user);
        for (SysUser s :
                sysUser) {
            System.out.println(s);
        }
    }

    @Test
    void setPasswordEncoder() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }

    @Test
    void setAuthorizeMapper(){
        List<String> allMenuByUserId = authorizeMapper.getAllMenuByUserId(2L);
        for (String list :
                allMenuByUserId) {
            System.out.println(list);
        }
    }

    @Test
    void demo1(){
        SysUser sysUser = new SysUser();
        sysUser.setUserId(2121212L);
        sysUser.setUserName("franklin");
        sysUser.setPassword("123123");
        sysUser.setNickName("哈哈哈");
        Boolean aBoolean = sysUserMapper.addSysUser(sysUser);
        System.out.println(aBoolean);
    }

    @Test
    void demo2(){
        SysUser sysUser = new SysUser();
        sysUser.setUserId(2121212L);
        sysUser.setNickName("呵呵呵");
        sysUser.setUserName("zhengkaibin");
        System.out.println(sysUserMapper.setSysUser(sysUser));
    }

    @Test
    void demo3(){
        boolean b = sysUserMapper.delSysUser(1L);
        System.out.println(b);
    }

}
