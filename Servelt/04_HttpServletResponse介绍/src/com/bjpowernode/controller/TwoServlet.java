package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TwoServlet")
public class TwoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 在实际开发过程中，都是通过out.print()将其数据写入到响应体中
         * 都用print 尽量不用writer
         * */

            int money = 50;//执行结果

            PrintWriter out = response.getWriter();
            //out.write(money); 弃用

            out.print(money);

    }
}
