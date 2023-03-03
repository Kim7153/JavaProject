package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "oneServlet")
public class oneServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName,money;
        //调用请求对象读取【请求头】参数信息
        userName = request.getParameter("userName");
        money = request.getParameter("money");
        //开卡
        Cookie card1 = new Cookie("userName",userName);
        Cookie card2 = new Cookie("money",money);
        //发卡 将Cookie写入到响应头交给浏览器
        response.addCookie(card1);
        response.addCookie(card2);
        //通知服务端将【点餐页面】内容写入到响应体交给浏览器(请求转发)
        request.getRequestDispatcher("/index_2.html").forward(request,response);
    }
}
