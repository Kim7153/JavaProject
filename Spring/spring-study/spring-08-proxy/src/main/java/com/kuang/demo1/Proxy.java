package com.kuang.demo1;

/**
 * @Author LYL
 * @create 2021/6/4 10:54
 */

//代理角色
//代理角色的目的就是为了帮助房东出租房子，同样有出租房子的动作，所以继承Rent
public class Proxy implements Rent{
    //代理需要拿到房东的资源
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    public Proxy() {
    }

    //出租房子的行为动作
    public void rent() {
        seeHouse();
        //帮助房东出租房子
        host.rent();
        fare();
    }
    //不仅要帮房东出租房子，代理中介还要干其他事（具体业务）
    //看房
    public void seeHouse(){
        //具体业务
        System.out.println("代理带客人去看房");
    }
    //收中介费
    public void fare(){
        //具体业务
        System.out.println("收钱");
    }
}
