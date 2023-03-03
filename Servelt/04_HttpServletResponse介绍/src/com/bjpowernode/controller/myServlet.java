package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class myServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String result = "Heool world!";//执行结果


        //------------响应对象将结果写入到响应体中----------------start

                //1、通过响应对象，想Tomcat索要输出流
                PrintWriter out = resp.getWriter();

                //2、通过输出流，将执行结果以二进制形式写入到响应体中
                out.write(result);//弃用

        //------------响应对象将结果写入到响应体中----------------start
    }//doGet执行完毕
    //Tomcat将响应包推送给浏览器解析
}
