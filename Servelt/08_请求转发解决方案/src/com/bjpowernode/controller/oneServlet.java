package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "oneServlet")
public class oneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("oneServlet 实现麻醉。。。。");
        //请求转发方案：
        //通过当前请求对象生成资源文件申请报告对象并发送给Tomcat
        request.getRequestDispatcher("/two").forward(request,response);
    }
}
