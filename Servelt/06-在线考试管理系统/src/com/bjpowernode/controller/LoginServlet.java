package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //初始化数据
        String userName,passWord;
        int result = 0;
        UserDao dao = new UserDao();
        //调用请求对象对请求体使用UTF-8字符集进行重新
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        //调用请求对象读取请求体参数信息
        userName = request.getParameter("userName");
        passWord = request.getParameter("passWord");

        //调用dao将查询验证信息推送到数据库服务器上
        result = dao.login(userName,passWord);
        //调用响应对象，根据验证结果将不同资源文件地址写入到响应头中，交给浏览器
        if (result == 1 ){//用户存在
                response.sendRedirect("/myWeb/index.html");
        }else {
                response.sendRedirect("/myWeb/login_error.html");
        }


    }

}
