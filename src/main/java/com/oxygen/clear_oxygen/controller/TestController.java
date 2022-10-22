package com.oxygen.clear_oxygen.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('sys:user:list')")
    public String user(){
        return "user success";
    }

    @GetMapping("/root")
    @PreAuthorize("hasAnyAuthority('sys:root:list')")
    public String root(){
        return "root success";
    }
}
