package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
   @RequestMapping("/")
     public String login(){
        return "login";
    }

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        if (username.equals("999") && password.equals("999")){
            session.setAttribute("loginUser",username);
            return "index";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
}
