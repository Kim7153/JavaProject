package com.kuang.demo4;

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
    private Object target;

    public void setRent(Object target) {
        this.target = target;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    // proxy : 代理类
    // method : 代理类的调用处理程序的方法对象.
    //处理代理实例，并返回结果
    //这里才是主方法的调用程序，所有的业务都是在这个方法中调用的
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //invoke 执行什么方法
        //动态道理的本质就是通过反射机制实现
        Object result = method.invoke(target, args);
        return result;
    }

}
