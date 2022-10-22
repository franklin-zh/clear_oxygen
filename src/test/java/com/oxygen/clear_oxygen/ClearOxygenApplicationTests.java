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
        user.setAvatar("dududu");
        SysUser sysUser = sysUserMapper.getSysUser(user);
        System.out.println(sysUser);
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

}
