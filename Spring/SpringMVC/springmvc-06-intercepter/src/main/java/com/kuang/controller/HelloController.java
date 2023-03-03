package com.kuang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LYL
 * @create 2021/7/17 19:34
 */
@RestController
public class HelloController {
    @RequestMapping("/a1")
    public String a1(){
        System.out.println("a1方法执行了");
        return "OK";
    }
}
