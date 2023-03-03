package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;

/**
 * @Author LYL
 * @create 2021/6/9 14:41
 */
public interface UserMapper {
    public List<User> selectUser();

    public int addUser(User user);

    public int deleteUser(int id);
}
