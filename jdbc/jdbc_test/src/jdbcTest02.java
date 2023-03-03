import javax.annotation.Resource;
import java.sql.*;
import java.util.ResourceBundle;

public class jdbcTest02 {
    public static void main(String[] args) {
        Connection coon = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","20141026");
            //获取连接对象
            stmt = coon.createStatement();
            //执行sql语句
            String sql = "select empno,ename,sal from emp";
            rs = stmt.executeQuery(sql);
            //处理查询结果集
//            while (rs.next()){
//                String empno = rs.getString(1);
//                String ename = rs.getString(2);
//                String sal = rs.getString(3);
//                System.out.println("empno:" + empno + "\t " +  "ename:" + ename + "\t" + "sal:" + sal);
//            }

            while (rs.next()){
                String empno = rs.getString("empno");//参数可以放列名
                String ename = rs.getString("ename");
                String sal = rs.getString("sal");
                System.out.println("empno:" + empno + "\t " +  "ename:" + ename + "\t" + "sal:" + sal);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
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
}
