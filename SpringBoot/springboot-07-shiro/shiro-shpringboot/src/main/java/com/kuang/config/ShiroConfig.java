package com.kuang.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //1.创建realm对象，需要自定义
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //2.DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm());
        return defaultWebSecurityManager;
    }

    //3.ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());

        //添加shiro的内置过滤器
        /*
        * anon:无需认证就可以访问
        * authc:必须认证才能访问
        * user：必须拥有 记住我 功能才能用
        * perms：拥有对某个资源的权限才能访问
        * role：拥有某个角色权限才能访问
        * */

        //没有权限会自动跳到登录页
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();


        //设置授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面 比如login
        //设置user下的add界面只能由 root下的kkk访问
        filterMap.put("/user/add","perms[root:kkk]");
        filterMap.put("/user/update","perms[root:jjj]");

/*        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");*/
        //在/user/*下面的所有页面都需要验证才能访问
        filterMap.put("/user/*","authc");


        //设置登录的请求的页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    //整合shiroDialect 用来整合shrio thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
