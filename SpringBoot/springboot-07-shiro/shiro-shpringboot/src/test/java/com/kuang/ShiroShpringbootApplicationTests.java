package com.kuang;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import com.kuang.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class ShiroShpringbootApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
        User users = userMapper.queryUser("测试1");
        System.out.println(users);

        /*System.out.println(userService.queryUser("测试1"));*/

    }


}
