package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId;
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int count = 0;
        UserDao dao = new UserDao();
        //1【调用请求对象】读取【请求头】参数（用户编号）
        userId = request.getParameter("userId");
        //2【调用DAO】将用户编号填充到delete命令发送到数据库服务器
        count = dao.delete(userId);
        //3【调用响应对象】将处理结果以二进制写入到响应体，交给浏览器
        if (count == 1){
            out.print("<script>window.alert('用户信息删除成功');</script>");
        }else {
            out.print("<script>window.alert('用户信息注册失败');</script>");
        }
    }
}
