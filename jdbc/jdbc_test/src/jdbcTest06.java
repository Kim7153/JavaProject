import java.sql.*;

public class jdbcTest06 {
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sensors","root","20141026");
            String sql = "select * from info";
            ps = coon.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("id:" + rs.getString("_id") + " "
                + "name:" + rs.getString("name") + " "
                + "miaoshu:" + rs.getString("miaoshu") + " "
                + "create_date:" + rs.getString("create_date") );
            }
        } catch (ClassNotFoundException | SQLException e) {
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

    }
}
