package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        int result = 0;
        PrintWriter out = response.getWriter();
        //1、【调用请求对象】 读取 【请求头】参数信息，得到用户的参数信息
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        if (userName == null || userName == "" ||passWord == null || passWord == " "){
            out.print("<script>window.alert('账号密码不能为空');</script>");
        }
        if (sex == null){
            out.print("<script>window.alert('性别不能为空');</script>");
        }
        if (email == null || email == ""){
            out.print("<script>window.alert('邮箱不能为空');</script>");
        }
        System.out.println(userName + "\n" + passWord + "\n" + sex + "\n" +email);

        //2、【调用UserDao】将用户信息填充到INSERT命令并借助JDBC规范发送到数据库服务器
        try {
            Users user = new Users(null,userName,passWord,sex,email);
            UserDao userDao = new UserDao();
            result = userDao.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3、【调用响应对象】将【处理结果】以二进制形式写入到响应体
        if (result == 1){
            out.print("<script>window.alert('用户信息注册成功');</script>");
        }else {
            out.print("<script>window.alert('用户信息注册失败');</script>");
        }
    }
        //自动完成
        //Tomcat负责销毁【请求对象】和【响应对象】
        //Tomcat负责将Http响应协议包推送到发起请求的浏览器上
        //浏览器根据响应头content-type指定的编译器对响应体二进制内容进行编译
        //浏览器将编译后结果在窗口中展示给用户【结束】
}
