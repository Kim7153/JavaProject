import java.sql.*;
/*

用PreparedStatement完成INSERT DELETE UPDATE
 */
public class jdbcTest {
    public static void main(String[] args){
        Connection coon = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;


        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","20141026");
            //获取连接对象和预编译sql语句
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = coon.prepareStatement(sql);
            //给占位符？传值
            ps.setInt(1,90);
            ps.setString(2,"销售部");
            ps.setString(3,"上海");
            //执行sql语句
            int count = ps.executeUpdate();
            System.out.println(count == 1? "成功" : "失败");


/*            //获取连接对象和预编译sql语句
            String sql = "update dept set dname = ? , loc = ? where deptno =?";
            ps = coon.prepareStatement(sql);
            //给占位符？传值
            ps.setString(1,"研发一部");
            ps.setString(2,"北京");
            ps.setInt(3,60);*/



            //获取连接对象和预编译sql语句
/*            String sql = "delete from dept where deptno = ?";
            ps = coon.prepareStatement(sql);
            //给占位符？传值
            ps.setInt(1,60);
            //执行sql语句
            int count = ps.executeUpdate();
            System.out.println(count);*/


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
}
