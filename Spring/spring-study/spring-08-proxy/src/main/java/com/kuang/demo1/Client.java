package com.kuang.demo1;

/**
 * @Author LYL
 * @create 2021/6/4 10:58
 */
//真实客户类
public class Client {
    public static void main(String[] args) {
        //房东要出租房子，需要看中房子的资源，资源在房东那 所以先new房东
        Host host = new Host();
        //因为房东不主动参与，所以资源交给代理完成
        Proxy proxy = new Proxy(host);
        //我们去找代理中介看房
        proxy.rent();
    }
}
