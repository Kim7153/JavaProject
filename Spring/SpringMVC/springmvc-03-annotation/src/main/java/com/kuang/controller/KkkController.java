package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author LYL
 * @create 2021/6/19 15:34
 */
@Controller
public class KkkController {
    @RequestMapping("/hello")
    public String kkk(Model model){
        model.addAttribute("msg","测试kkk，SpringMVC");
        return "kkk";
    }
}
