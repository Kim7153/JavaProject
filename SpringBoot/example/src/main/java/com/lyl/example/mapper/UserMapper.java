package com.lyl.example.mapper;

import com.lyl.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    //查询所有
    List<User> selectAll();
    //根据id查询用户
    User selectById(@Param("id") int id);
    //增加用户
    int addUser(User user);
    //根据id删除用户
    int deleteUsrById(@Param("id") int id);
    //修改用户信息
    int updateUser(User user);
}
