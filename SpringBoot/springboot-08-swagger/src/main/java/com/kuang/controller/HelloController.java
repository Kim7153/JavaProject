package com.kuang.controller;

import com.kuang.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String helloController(){
        return "hello";
    }

    @PostMapping(value = "/User")
    public User User(){
        return User();
    }

    //ApiOperation 放在方法上，用来中文注释方法
    @ApiOperation("Hello控制类")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String userName){
        return "hello" + userName;
    }

}
