package com.kuang.Mapper;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User getUserId(int id);

    List<User> getUserByLimit(Map<String,Object> map);
}
