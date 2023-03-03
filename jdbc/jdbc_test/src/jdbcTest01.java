import java.sql.*;
import java.util.ResourceBundle;

public class jdbcTest01 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            conn = DriverManager.getConnection(url,user,password);
            //获取连接数据库操作对象
            stmt = conn.createStatement();
            //执行SQL语句
            String sql = "insert into dept1(deptno,dname,loc) values (10,'lyl','赣州')";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1? "添加成功" : "添加失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt !=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
