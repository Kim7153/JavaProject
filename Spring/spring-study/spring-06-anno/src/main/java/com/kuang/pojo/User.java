package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author LYL
 * @create 2021/6/2 17:24
 */

// 相当于配置文件中 <bean id="kkk" class="com.kuang.pojo.User"/>
@Component(value = "kkk")
public class User {
    // 相当于配置文件中 <property name="name" value="秦疆"/>
    @Value("秦疆")
    public String name = "罗依龙";

}
