package com.bjpowernode.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcUtil {
    String url = "jdbc:mysql://localhost:3306/cookie";
    String username = "root";
    String password = "20141026";
        static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,username,password);
    }
}
