package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class twoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int jiaozi_money = 30;
        int gaifan_money = 15;
        int miantiao_money = 20;
        String food,userName = null;
        int money = 0;
        Cookie cookieArray[] = null;
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //读取请求头参数信息，得到用户点餐食物类型
        food = request.getParameter("food");
        //读取请求头中的Cookie
        cookieArray = request.getCookies();
        //刷卡消费
        for (Cookie card : cookieArray){
            String key = card.getName();
            String value = card.getValue();
            if ("userName".equals(key)){
                userName = value;
            }else if ("money".equals(key)){
                money = Integer.valueOf(value);
                if ("饺子".equals(food)){
                    if (jiaozi_money > money){
                        out.print("用户" + userName + "余额不足，请充值");
                    }else {

                    }
                }else if ("面条".equals(food)){
                    if (miantiao_money > money){
                        out.print("用户" + userName + "余额不足，请充值");
                    }
                }else if ("盖饭".equals(food)){
                    if (gaifan_money > money){
                        out.print("用户" + userName + "余额不足，请充值");
                    }
                }
            }
        }
    }
}
