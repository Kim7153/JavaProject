package com.kuang.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author LYL
 * @create 2021/6/8 10:31
 */

public class BeforeLog implements MethodBeforeAdvice {
    //method : 要执行的目标对象的方法
    //args : 被调用的方法的参数
    //target : 目标对象
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //System.out.println(target.getClass().getName() + "的" + method.getName() + "方法被执行了");
    }
}
