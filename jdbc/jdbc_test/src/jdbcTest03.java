
    /*
实现功能：
    1、需求，模拟用户登录功能的实现
    2、业务描述：
        程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码
        用户输入用户名和密码之后，提交信息，java程序手机到用户信息
        java程序连接数据库验证用户名和密码是否合法
        合法：显示登陆成功
        不合法：显示登陆失败
    3、数据的准备：
        在实际开发中，标的设计会使用专业的建模工具，我们这里安装一个建模工具：PowerDesigner
        使用PD工具来进行数据库设表的设计（参见user-login.sql脚本）
     */

    import java.sql.*;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class jdbcTest03 {
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
            Statement stmt = null;
            ResultSet rs = null;
            String loginName = userLoginInfo.get("loginName");
            String loginPwd = userLoginInfo.get("loginPwd");
            try {
                //注册驱动
                Class.forName("com.mysql.jdbc.Driver");
                //连接
                coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","20141026");
                //获取连接对象
                stmt = coon.createStatement();
                //执行sql
                String sql = "select * from t_user where loginName = '"+ loginName +"' and loginPwd = '"+ loginPwd +"'";
                rs = stmt.executeQuery(sql);
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
