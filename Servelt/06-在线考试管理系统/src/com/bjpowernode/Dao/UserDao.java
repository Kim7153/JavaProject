package com.bjpowernode.Dao;

import com.bjpowernode.Util.JdbcUtil;
import com.bjpowernode.entity.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcUtil util = new JdbcUtil();
    //用户注册
    public int add(Users user) throws Exception {
        String sql = "insert into users(userName,password,sex,email) values(?,?,?,?)";
        PreparedStatement ps = util.getCoon().prepareStatement(sql);
        ps.setString(1,user.getUserName());
        ps.setString(2,user.getPassWord());
        ps.setString(3,user.getSex());
        ps.setString(4,user.getEmail());
        int result = ps.executeUpdate();
        return result;
    }
    //查询所有用户信息
    public List findALL() throws Exception{
        String sql = "select * from users";
        PreparedStatement ps = util.getCoon().prepareStatement(sql);
        ResultSet rs = null;
        rs = ps.executeQuery();
        List userList = new ArrayList();
        while (rs.next()){
            Integer userId = rs.getInt("userId");
            String userName = rs.getString("userName");
            String passWord = rs.getString("passWord");
            String sex = rs.getString("sex");
            String email = rs.getString("email");
            Users users = new Users(userId,userName,passWord,sex,email);
            userList.add(users);
        }
        return userList;
    }
    ////根据用户编号删除用户信息
    public int delete(String userId){
        int count = 0;
        try {
            String sql = "delete from users where userId = ?";
            PreparedStatement ps = util.getCoon().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(userId));
            count = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
    //登录验证
    public int login(String userName,String passWord){
        String sql = "select count(*) from users where userName = ? and passWord = ?";
        ResultSet rs = null;
        int result = 0;
        try {
            PreparedStatement ps = util.getCoon().prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,passWord);
            rs = ps.executeQuery();
            while (rs.next()){
               result =  rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return result;
    }

}
