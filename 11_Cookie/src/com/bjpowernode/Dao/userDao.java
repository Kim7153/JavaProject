package com.bjpowernode.Dao;

import com.bjpowernode.entity.users;
import com.bjpowernode.util.jdbcUtil;

import java.sql.PreparedStatement;

public class userDao {
    jdbcUtil util = new jdbcUtil();

    //用户申请开户
    public int add(users user) throws Exception{
        String username = user.getUsername();
        String money = user.getMoney();
        String sql = "insert into users(username,money) values(?,?)";
        PreparedStatement ps = util.getConnection().prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,money);
        int count = ps.executeUpdate();
        return count;
    }
    public int updateMoney(int money,int price){
        String sql = "update cookie set money=(" + (money - price) +") where money='123'";
        return 0;
    }
}
