package com.oxygen.clear_oxygen.headler;

import com.alibaba.fastjson.JSON;
import com.oxygen.clear_oxygen.common.Result;
import com.oxygen.clear_oxygen.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 鉴权失败处理器
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result<String> result = new Result<>(HttpStatus.FORBIDDEN.value(), "用户鉴权失败请重新登录");
        String resultJSON = JSON.toJSONString(result);
        WebUtil.renderString(response, resultJSON);
    }
}
