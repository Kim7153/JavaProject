package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //制定请求授权规则
        //authorizeRequests 请求授权认证，首页所有人都可以访问，功能页只有对应授权的人才能访问
        http.authorizeRequests()
                .antMatchers("/","/user/login").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //没有权限会到登录页面
        http.formLogin();
    }

    //制定认证用户和范围
    //密码编码
    //正常应该再数据库中读
    //inMemoryAuthentication 从内存中读取
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2");
/*                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3");*/

    }
}
