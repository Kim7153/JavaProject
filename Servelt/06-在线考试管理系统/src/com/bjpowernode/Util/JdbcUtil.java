package com.bjpowernode.Util;

import java.sql.*;

public class JdbcUtil {
     String url = "jdbc:mysql://localhost:3306/bjpowernode";
     String userName = "root";
     String passWord = "20141026";
     PreparedStatement ps = null;
     Connection coon = null;
     ResultSet rs = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getCoon() throws Exception{
        return DriverManager.getConnection(url,userName,passWord);
    }
    public void close(Connection coon,PreparedStatement ps,ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (coon != null){
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
