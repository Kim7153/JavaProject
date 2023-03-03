package com.blog.jxhj.mapper;

import com.blog.jxhj.pojo.TArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author LYL
 * @create 2021/7/19 15:33
 */
@Mapper
@Component
public interface TArticleMapper {
    //查询所有
    List<TArticle> queryAll ();
    //添加书籍
    int addTArticle(TArticle tArticle);
    //修改书籍
    int updateTArticle(TArticle tArticle);
    //删除
    int deleteTArticle(@Param("id") int id);
    //分页查询
    List<TArticle> selectByPage(@Param("article") TArticle tArticle,@Param("page") int page,@Param("pageSize") int pageSize);
    //根据id查询详细
    TArticle selectById(@Param("id") Integer id);
}
