package com.blog.jxhj;

import com.blog.jxhj.mapper.TArticleMapper;
import com.blog.jxhj.pojo.TArticle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author LYL
 * @create 2021/7/19 15:42
 */
@SpringBootTest
public class MyTest {
    @Autowired
    TArticleMapper tArticleMapper;

    @Test
    void test(){

        List<TArticle> tArticles = tArticleMapper.queryAll();
        for (TArticle tArticle : tArticles) {
            System.out.println(tArticle);
        }
    }
    @Test
    void helloworld(){
        System.out.println("helloworld");
    }
}
