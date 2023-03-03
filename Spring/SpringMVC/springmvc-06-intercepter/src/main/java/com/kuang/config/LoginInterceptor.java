package com.kuang.config;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author LYL
 * @create 2021/7/17 20:44
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //放行：判断什么情况下登录
        if (request.getRequestURI().contains("toLogin")){
            return true;
        }
        if (request.getRequestURI().contains("login")){
            return true;
        }
        if (session.getAttribute("loginInfo") != null){
            return true;
        }

        //不放行：判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
