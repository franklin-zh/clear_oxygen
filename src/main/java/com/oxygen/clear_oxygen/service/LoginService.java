package com.oxygen.clear_oxygen.service;

import com.oxygen.clear_oxygen.PO.SysUser;
import com.oxygen.clear_oxygen.common.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface LoginService {
    Result<Map<String, String>> login(SysUser user);
}
