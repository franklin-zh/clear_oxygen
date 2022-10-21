package com.oxygen.clear_oxygen.service.impl;

import com.oxygen.clear_oxygen.PO.SysUser;
import com.oxygen.clear_oxygen.POJO.LoginUser;
import com.oxygen.clear_oxygen.common.Result;
import com.oxygen.clear_oxygen.dao.SysUserMapper;
import com.oxygen.clear_oxygen.service.LoginService;
import com.oxygen.clear_oxygen.utils.JwtUtil;
import com.oxygen.clear_oxygen.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *  登录业务逻辑
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Result<Map<String, String>> login(SysUser user) {

        if (Objects.isNull(user)){
            Map<String, String> map = new HashMap<>();
            map.put("data", "参数错误");
            return new Result<>(404, "error", map);
        }

        // 1.调用authentication进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 2.如果认证没通过，给出对应提示
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }

        // 3.如果认证通过了，使用userid生成一个jwt jwt存入Result进行返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        long id = loginUser.getUser().getUserId();
        System.out.println(id);
        String jwt = JwtUtil.createJWT(Long.toString(id));

        // 4.把完整用户信息存入redis userid作为key
        redisCache.setCacheObject("token:" + id, loginUser);

        // 5.返回结果
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return new Result<>(200, "登录成功", map);
    }
}
