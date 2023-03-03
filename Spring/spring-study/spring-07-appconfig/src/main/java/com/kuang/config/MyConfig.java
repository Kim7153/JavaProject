package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LYL
 * @create 2021/6/3 15:09
 */
@Configuration
public class MyConfig {
    @Bean
    public User getUser(){
        return new User();
    }

}
