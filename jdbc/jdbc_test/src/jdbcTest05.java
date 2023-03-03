import java.sql.*;

public class jdbcTest05 {
    /*

    演示自动提交事务：银行转账
    建表语句
    drop table if exists t_act;
    create table t_act(
        actno int,
        balance double(7,2)
    );
    insert into t_act(actno,balance) values(111,20000);
    insert into t_act(actno,balance) values(222,0);
    commit;
    select * from t_act;
     */
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement ps = null;


        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","20141026");
            //开启事务,把自动提交事务改为手动提交事务
            coon.setAutoCommit(false);
            //获取预编译处理对象
            String sql = "update t_act set balance = ? where actno = ?";
            ps = coon.prepareStatement(sql);
            //给?赋值
            ps.setDouble(1,10007);
            ps.setInt(2,111);
            //执行提交sql
            int count = ps.executeUpdate();
            System.out.println(count);

/*            String s = null;
            s.toString();*/

            ps.setDouble(1,10000);
            ps.setInt(2,222);
            //执行提交sql
            count += ps.executeUpdate();
            //提交事务
            coon.commit();
            System.out.println(count == 2 ? "成功":"失败");

        } catch (Exception e) {
            if (coon != null){
                try {
                    coon.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
