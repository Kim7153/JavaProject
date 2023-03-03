package com.kuang.demo2;

/**
 * @Author LYL
 * @create 2021/6/4 16:40
 */


public class UserServiceProxy implements UserService{
    //代理类同样实现与原业务代码一样的接口，并做一样的事情
    //所以要把原业务代码拿过来
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void update() {
        log("update");
        userService.update();
    }

    public void query() {
        log("query");
        userService.query();
    }

    //新增的业务功能逻辑代码
    public void log(String msg){
        System.out.println("执行了"+ msg+"方法");
    }

}
