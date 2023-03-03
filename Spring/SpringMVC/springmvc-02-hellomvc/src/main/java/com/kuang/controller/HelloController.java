package com.kuang.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //业务代码
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","HelloSpringMVC！");
        //视图解释跳转页面
        mv.setViewName("text");//需要拼接的视图名称，参考视图解析器的代码实际地址就是（/WEB-INF/jsp/text.jsp）
        return mv;
    }
} 