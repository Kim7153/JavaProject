package com.blog.jxhj.controller;

import com.alibaba.fastjson.JSONArray;
import com.blog.jxhj.mapper.TArticleMapper;
import com.blog.jxhj.pojo.TArticle;
import com.blog.jxhj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author LYL
 * @create 2021/7/14 10:33
 */
@RestController
@CrossOrigin
public class HelloController {
    @Autowired
    TArticleMapper tArticleMapper;

    @GetMapping("/hello")
    public String say(@RequestParam("id") String id,@RequestParam("name") String name){
        System.out.println(id);
        System.out.println(name);
        return "Hello Controller888";
    }

    @PostMapping("/vueTest")
    public User vueTest(@RequestBody User user){
        System.out.println(user.getId());
        System.out.println(user.getName());
        return user;
    }

    @RequestMapping("/list")
    public List<TArticle> list(){
        List<TArticle> tArticles = tArticleMapper.queryAll();
        for (TArticle tArticle : tArticles) {
            System.out.println(tArticle);
        }
        return tArticles;
    }

    @RequestMapping("/selectByPage")
    public List<TArticle> selectByPage(TArticle article,
                                       @RequestParam(required = false,defaultValue = "1") int page,
                                       @RequestParam(required = false,defaultValue = "10") int pageSize){
        if (page <= 0 ){
            page =1;
        }
        int newPage = (page - 1) * pageSize;
        return tArticleMapper.selectByPage(article,newPage,pageSize);
    }
    @RequestMapping("/addTArticle")
    public int addTArticle(TArticle tArticle){
        int i = tArticleMapper.addTArticle(tArticle);
        return i;
    }
    @RequestMapping("/updateTArticle")
    public int updateTArticle(TArticle tArticle){
        int i = tArticleMapper.updateTArticle(tArticle);
        return i;
    }
    @RequestMapping("/deleteTArticle")
    public int updateTArticle(@RequestParam("id") int id){
        int i = tArticleMapper.deleteTArticle(id);
        return i;
    }
    @RequestMapping("/selectById")
    public TArticle selectById(@RequestParam("id") int id){
        TArticle tArticle = tArticleMapper.selectById(id);
        return tArticle;
    }
}
