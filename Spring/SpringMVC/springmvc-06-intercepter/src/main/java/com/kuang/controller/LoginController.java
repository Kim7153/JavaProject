package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author LYL
 * @create 2021/7/17 20:25
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password,Model model){
        model.addAttribute("username",username);
        session.setAttribute("loginInfo",username);
        return "main";
    }
    @RequestMapping("/goOut")
    public String login(HttpSession session){
        session.removeAttribute("loginInfo");
        return "login";
    }

}
