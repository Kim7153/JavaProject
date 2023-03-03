package com.kuang.demo2;

/**
 * @Author LYL
 * @create 2021/6/4 16:35
 */
public class Client {
    public static void main(String[] args) {
        //真实业务
        UserServiceImpl userService = new UserServiceImpl();
        //代理类
        UserServiceProxy proxy = new UserServiceProxy();
        //使用代理类实现日志功能！
        proxy.setUserService(userService);

        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.query();
    }
}
