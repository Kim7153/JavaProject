package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询博客中的所有数据
    List<Blog> getBlogAllIf(Map<String,Object> map);

    List<Blog> getBlogAllChoose(Map<String,Object> map);

    //修改数据库中的数据
    int updateBlog(Map map);

    //查询1 2 3号 记录
    List<Blog> queryBlogForeach(Map map);
}
