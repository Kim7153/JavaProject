package com.kuang.controller;

import com.kuang.pojo.User;
import com.sun.deploy.net.HttpResponse;
import com.sun.net.httpserver.HttpServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LYL
 * @create 2021/7/16 10:36
 */
@RestController
public class HelloController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println(name);
        if ("kuangshen".equals(name)){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("kkk",5,"nan"));
        userList.add(new User("jjj",5,"nan"));
        userList.add(new User("kkk",5,"nan"));
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String username,String pwd){
        String msg = "";
        if (username != null){
            if ("admin".equals(username)){
                msg = "ok";
            }else {
                msg = "用户名有误";
            }
        }
        if (pwd != null){
            if ("123456".equals(pwd)){
                msg = "ok";
            }else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
