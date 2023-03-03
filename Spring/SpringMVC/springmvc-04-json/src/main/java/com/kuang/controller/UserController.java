package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author LYL
 * @create 2021/6/21 17:13
 */
@RestController
public class UserController {
    @RequestMapping("/j1")
    public String test1() throws JsonProcessingException {
        User user = new User("唉",3,"男");
        return JsonUtil.getJson(user);
    }

    @RequestMapping("/j2")
    public String test2() throws JsonProcessingException {
        List<User> userList = new ArrayList<User>();
        User user1 = new User("奥斯丁1",3,"男");
        User user12 = new User("奥斯丁12",3,"男");
        User user13 = new User("奥斯丁13",3,"男");
        User user15 = new User("奥斯丁15",3,"男");
        User user14 = new User("奥斯丁14",3,"男");
        userList.add(user1);
        userList.add(user12);
        userList.add(user13);
        userList.add(user15);
        userList.add(user14);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user12);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));
        System.out.println(jsonObject1);

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);
        return JSON.toJSONString(userList);
    }

    @RequestMapping("/j3")
    public String test3() throws JsonProcessingException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        return JsonUtil.getJson(sdf.format(date));
    }
}
