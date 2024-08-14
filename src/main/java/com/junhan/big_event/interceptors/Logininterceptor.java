package com.junhan.big_event.interceptors;

import com.junhan.big_event.utils.JwtUtil;
import com.junhan.big_event.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class Logininterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //令牌驗證
        String token = httpServletRequest.getHeader("Authorization");
        //驗證token
        try {
            Map<String, Object> map = JwtUtil.parseToken(token);
            //把業務數據存到ThreadLocal中
            ThreadLocalUtil.set(map);
            //放行
            return true;
        }catch (Exception e){
            httpServletResponse.setStatus(401);
            //不放行
            return false;
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        ThreadLocalUtil.remove();
    }
}
