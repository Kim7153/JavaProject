package com.kuang.pojo;

/**
 * @Author LYL
 * @create 2021/5/31 20:32
 */
public class User {
    private String userName;

    public User(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void show(){
        System.out.println(this.userName);
    }

}

