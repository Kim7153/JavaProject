package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author LYL
 * @create 2021/6/21 14:50
 */
@Controller
public class EncodingController {
    @PostMapping("/e/t1")
    public String test1(String name, Model model){
        //过滤器解决乱码
        System.out.println(name);
        model.addAttribute("msg",name);
        return "kkk";
    }
}
