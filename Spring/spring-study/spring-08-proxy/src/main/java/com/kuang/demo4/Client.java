package com.kuang.demo4;

import com.kuang.demo2.UserService;
import com.kuang.demo2.UserServiceImpl;

/**
 * @Author LYL
 * @create 2021/6/6 16:54
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色：现在没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过调用程序处理角色（ProxyInvocationHandler）来处理我们要调用的接口对象
        pih.setRent(userService);
        UserService proxy = (UserService) pih.getProxy();//这里的proxy就是动态生成的
        proxy.add();
    }
}
