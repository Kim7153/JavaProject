import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*

对比一下Statement和PreperdStatement?
    Statement存在sql注入问题，PreparedStatement解决了sql注入问题
    Statement编译一次执行一次，PreparedStatement编译一次，执行N次，PreparedStatement执行效率更高一点
    PreParStatement会在编译阶段进行类型的安全检查

什么情况下必须使用Statement
    业务要求必须支持sql注入的时候

 */

public class jdbctest04 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String,String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        //最后输出结果
        System.out.println(loginSuccess? "登录成功" : "登录失败");
    }

    /**
     * 用户登录
     * @param userLoginInfo 用户登录信息
     * @return false表示失败 true表示成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        boolean loginSuccess = false;
        //JDBC代码
        Connection coon = null;
        PreparedStatement ps = null;//与便于的数据库操作对象
        ResultSet rs = null;
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","20141026");
            //编写预编译SQL语句
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";
            //获取连接对象
            ps = coon.prepareStatement(sql);
            //给占位符?传值（第1个问号下标是1，第2个问号下标是2，JDBC中所有下边都是从1开始的）
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);
            //执行sql
            rs = ps.executeQuery();
            //处理查询结果集
            if (rs.next()){
                loginSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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

        return loginSuccess;
    }


    /**
     * 初始化用户界面
     * @return 用户输入的用户名和密码等登陆信息
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名：");
        String loginName = s.nextLine();

        System.out.println("密码：");
        String loginPwd = s.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);

        return userLoginInfo;
    }


}
