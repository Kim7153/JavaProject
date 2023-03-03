package com.blog.jxhj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author LYL
 * @create 2021/7/19 15:29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TComment {
    private Integer id;
    private String content;
    private String author;
    private Integer a_id;
}
