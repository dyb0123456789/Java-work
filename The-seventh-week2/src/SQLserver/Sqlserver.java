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
            // �������ݿ�
            conn = DriverManager.getConnection(url, user, password);
            // ����Statement����
            stmt = conn.createStatement();
            // ִ�����ݿ��ѯ���
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                int age = rs.getInt("age");
                String address = rs.getString("address");
               System.out.println("ѧ�� "+sno+"���� "+sname+"���� "+age+"��ַ "+address);
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
            System.out.println("���ݿ�����ʧ��");
        }
    }
}
