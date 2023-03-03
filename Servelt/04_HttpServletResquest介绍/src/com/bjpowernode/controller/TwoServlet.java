package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过请求对象获得【请求头】中【所有请求参数名】
        Enumeration pareNames = request.getParameterNames();//将所有请求参数名称保存到一个枚举对象中进行返回
        //遍历枚举
        while (pareNames.hasMoreElements()){
            String pareName = (String) pareNames.nextElement();

            //通过请求对象取出指定的请求参数名对应的值
            String canshuzhi = request.getParameter(pareName);
            System.out.println("请求参数名:" + pareName + "," + "值:" + canshuzhi);
        }
    }
}
