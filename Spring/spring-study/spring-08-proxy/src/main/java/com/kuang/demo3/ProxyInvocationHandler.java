package com.kuang.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author LYL
 * @create 2021/6/6 16:42
 */
//我们会用这个类，自动生成代理类！
public class ProxyInvocationHandler implements InvocationHandler {
    //把被代理的接口拿过来，后续传值可以传实现类 多态
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    //处理代理实例，并返回结果
    //这里才是主方法的调用程序，所有的业务都是在这个方法中调用的
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //invoke 执行什么方法
        //动态道理的本质就是通过反射机制实现
        seeHouse();
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }
    //新增业务
    public void seeHouse(){
        System.out.println("中介带去看房子");
    }
    //新增业务
    public void fare(){
        System.out.println("收中介费");
    }
}
