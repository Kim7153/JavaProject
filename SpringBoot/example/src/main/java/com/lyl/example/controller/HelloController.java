package com.lyl.example.controller;

import com.lyl.example.mapper.UserMapper;
import com.lyl.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyl
 * https://code-with-me.global.jetbrains.com/2-FnJP0fjas716bo7QQi_Q#p=IU&fp=F5B0A9313AD5C48CADBB29FC0439CD5FCA2D6F65706EE594C2B639BF93D917F1
 */
@RestController
@CrossOrigin
public class HelloController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/hello")
    public String Hello(){
        return "hello test code with me";
    }

    @GetMapping("/list")
    public List<User> selectAll(){
        List<User> users = userMapper.selectAll();
        System.out.println(users);
        return users;
    }

    @GetMapping("/selectById")
    public User selectUserById(@RequestParam("id") int id){
        User user = userMapper.selectById(id);
        return user;
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody User user){
        int i = userMapper.addUser(user);
        return i;
    }

    @GetMapping("/deleteUsrById")
    public int deleteUsrById(@RequestParam("id") int id){
        int i = userMapper.deleteUsrById(id);
        return i;
    }

    @PostMapping("/updateUser")
    public int updateUser(@RequestBody User user){
        int i = userMapper.updateUser(user);
        return i;
    }
}
