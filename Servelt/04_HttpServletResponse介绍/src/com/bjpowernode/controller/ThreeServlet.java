package com.bjpowernode.controller;

import sun.java2d.pipe.OutlineTextRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ThreeServlet")
public class ThreeServlet extends HttpServlet {
    /*
     *问题描述：Java<br/>MySQL<br/>HTML<br/>
     *      浏览器在接收到响应结果时 将<br/>作为文字内容在窗口展示出来
     *      没有将<br/>当做HTML标签命令执行
     *
     *
     * 问题原因：
     *      浏览器在接受到响应包之后，根据【响应头中content-type】
     *      属性的值，来采取对应【编译器】对【响应体中二进制内容】进行
     *      解析
     *
     *      在默认情况下，content-type属性的值"text" content-type = "text"
     *      此时浏览器将会采用【文本编译器】对响应体中二进制数据进行解析
     * 解决方案：
     *      一定要在得到输出流之前，通过响应对象对响应头中content-type属性进行
     *      一定重新赋值用于指定浏览器采用正确编译器
     *
     * */


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String result = "Java<br/>MySQL<br/>HTML<br/>";//既有文字又有HTML标签命令
            String result2 = "红烧排骨<br/>糖醋里脊<br/>梅菜扣肉<br/>";
            //  设置响应头content-type
            response.setContentType("text/html;charset=utf-8");
            //response.setCharacterEncoding("UTF-8");
            //  索要输出流
            PrintWriter out = response.getWriter();
            out.print(result);
            out.print(result2);
    }
}
