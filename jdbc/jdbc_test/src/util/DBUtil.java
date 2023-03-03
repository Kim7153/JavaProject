package util;

import java.sql.*;

/**
 *JDBC工具类，简化JDBC编程
 *
 */
public class DBUtil {
    /**
     * 工具类中的构造方法都是私有的
     * 因为工具类的方法都是静态的，不需要new对象，直接用类名调用
     */
    private DBUtil(){}

    /**
     * 静态代码块中的代码只在编译时执行一次
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return 返回连接对象
     * @throws Exception SQLException
     */
    //封装连接类
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection("jdbc:mysql://locakhost:3306/bjpowernode","root","20141026");
    }


    /**
     *
     * @param coon 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集
     */
    //封装关闭类
    public static void close(Connection coon, Statement ps,ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (coon != null) {
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
