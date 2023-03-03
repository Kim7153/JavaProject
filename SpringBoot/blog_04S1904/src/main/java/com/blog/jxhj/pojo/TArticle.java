package com.blog.jxhj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author LYL
 * @create 2021/7/19 15:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TArticle {
    private Integer id;
    private String title;
    private String content;
    private String intro;
    private Date createTime;
    private List<TComment> commentList;
    public TArticle(String title,String content,String intro,Date createTime){
        this.title = title;
        this.content = content;
        this.intro = intro;
        this.createTime = createTime;
    };
    public TArticle(int id,String title,String content,String intro,Date createTime){
        this.id = id;
        this.title = title;
        this.content = content;
        this.intro = intro;
        this.createTime = createTime;
    };
}
