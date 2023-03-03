package com.kuang.demo2;

/**
 * @Author LYL
 * @create 2021/6/4 16:33
 */

//需要一个真实的人来完成这个操作

//假设这是一个完整的上线业务，突然有一天要增加需求
    //这个时候就需要一个副本来新增业务，副本可以做到不改变原有的UserServiceImpl代码而新增业务
    //一旦新增的业务崩溃了，直接删除就好，原有的功能并不会受到影响，于是代理就出来了

public class UserServiceImpl implements UserService{
    public void add() {
        System.out.println("增加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("修改了一个用户");
    }

    public void query() {
        System.out.println("查询了一个用户");
    }
}
