package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LYL
 * @create 2021/6/23 15:24
 */
public interface BookMapper {
    //增加一本图书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookId")int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookId") int id);

    //查询全部书
    List<Books> queryAllBook();
}
