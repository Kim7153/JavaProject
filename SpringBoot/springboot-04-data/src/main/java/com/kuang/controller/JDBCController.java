package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    //没有实体类，数据库中的东西怎么获取，Map
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //添加用户
    @GetMapping("/addUser")
    public int addUser(){
        String sql = "insert into user(id,name,pwd) values(9,'咳咳','999')";
        int count = jdbcTemplate.update(sql);
        return count;
    }

    //修改用户
    @GetMapping("/updateUser/{id}")
    public int updateUser(@PathVariable("id") int id){
        String sql = "update user set name=? , pwd=? where id="+id;
        //封装
        Object[] o = new Object[2];
        o[0] = "小名2";
        o[1] = "zzz";
        int count = jdbcTemplate.update(sql,o);
        return count;
    }

    @GetMapping("/deleteUser/{id}")
    public int deleteUserById(@PathVariable("id") int id){
        String sql = "delete from user where id=?";
        int count = jdbcTemplate.update(sql,id);
        return count;
    }
}
