package com.oxygen.clear_oxygen.controller;

import com.oxygen.clear_oxygen.PO.SysUser;
import com.oxygen.clear_oxygen.common.Result;
import com.oxygen.clear_oxygen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *   用户登录接口
 */
@RestController
@RequestMapping("/system")
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/login")
    public Result<Map<String, String>> login(@RequestBody SysUser user){
        return service.login(user);
    }
}
