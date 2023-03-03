package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    //查
    @Test
    public void test(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行sql
        //方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
    }


    @Test
    public void getUserById(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
    @Test
    //查 Map方式传递数值
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",3);
        User userById2 = mapper.getUserById2(map);
        sqlSession.commit();
        System.out.println(userById2);
        sqlSession.close();
    }

    //增
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.addUser(new User(6,"kkk","kkk",99));
        if(count > 0) {
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //map方式增加
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",7);
        map.put("name","233233");
        map.put("major","233233");
        map.put("sno","233233");
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }

    //改
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5,"kkk","软工",66));
        sqlSession.commit();
        sqlSession.close();
    }

    //删
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(7);
        sqlSession.commit();
        sqlSession.close();
    }

}
