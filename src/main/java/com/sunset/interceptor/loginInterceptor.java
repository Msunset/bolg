package com.sunset.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class loginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUsername = request.getSession().getAttribute("user");
        if (loginUsername !=null){
            return true;
        }else {
            request.setAttribute("msg","没有权限访问，请先登录！");
            response.sendRedirect("/admin");
            return false;
            //跳转到后台页面
        }
    }
}
