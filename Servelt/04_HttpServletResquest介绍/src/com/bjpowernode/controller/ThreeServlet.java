package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ThreeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过请求对象，读取【请求体】参数信息
        request.setCharacterEncoding("UTF-8");
        String userNmae = request.getParameter("userName");
        System.out.println("从请求体得到参数值" + userNmae);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过请求对象，读取【请求头】参数信息
        String userNmae = request.getParameter("userName");
        System.out.println("从请求头得到参数值" + userNmae);
    }
}
