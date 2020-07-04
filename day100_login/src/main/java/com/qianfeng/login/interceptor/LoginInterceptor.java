package com.qianfeng.login.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String[] str = requestURI.split("/");
        String path = str[str.length - 1];
        if(path.endsWith("js")){
            return true;
        }
        if (!path.contains("login")){
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                return true;
            }else{
                String LoginPath=request.getContextPath()+"login.html";
                response.sendRedirect(LoginPath);
                return false;
            }
        }
        return true;
    }
}
