package SQLserver;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class Sqlserver {
	public static void main(String[] args) {
        String user = "sa";
        String password = "123456";
        Connection conn;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=study;";
        String sql = "select * from student";
        try {
            // 连接数据库
            conn = DriverManager.getConnection(url, user, password);
            // 建立Statement对象
            stmt = conn.createStatement();
            // 执行数据库查询语句
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                int age = rs.getInt("age");
                String address = rs.getString("address");
               System.out.println("学号 "+sno+"姓名 "+sname+"年龄 "+age+"地址 "+address);
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
