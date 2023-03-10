package com.kuang.diy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author LYL
 * @create 2021/6/8 14:51
 */

@Aspect
@Component
public class AnnotationPointCut {
    @Before("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("====在方法之前====");
    }
/*
    @After("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("---------方法执行后---------");
    }
    @Around("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        //System.out.println("签名:"+jp.getSignature());
        //执行目标方法
        Object proceed = jp.proceed();
        System.out.println("环绕后");
        //System.out.println(proceed);
    }*/
}
