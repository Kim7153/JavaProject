package com.kuang.demo1;

/**
 * @Author LYL
 * @create 2021/6/4 10:52
 */
//真实的房东角色
public class Host implements Rent{
    //房东要出租房子，所以实现出租的动作
    public void rent() {
        //具体业务，用输出语句代替
        System.out.println("房东出租了房子！！！");
    }

}
