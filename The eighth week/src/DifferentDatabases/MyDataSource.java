package DifferentDatabases;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.*;

public class MyDataSource implements DataSource {
    // ��Ϊ LinkedList ��������ʵ�ֵ�,������ɾʵ�������Ƚ�����
    LinkedList<Connection> dataSources = new LinkedList<Connection>();
    String driver ="com.mysql.jdbc.Driver";//����������
	String url ="jdbc:MySQL://localhost:3306/study";//urlָ��Ҫ���ʵ����ݿ�study
	String user ="root";//MySQL����ʱ���û���
	String password ="123456";//MySQL����ʱ������
	
	//Sqlserver
	String url1 ="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=study;";//urlָ��Ҫ���ʵ����ݿ�study
	String user1 ="sa";//MySQL����ʱ���û���
	String password1 ="123456";//MySQL����ʱ������
    public MyDataSource() {
        // ���⣺ÿ��new MyDataSource ���Ὠ�� 10 �����ӣ���ʹ�õ������ģʽ�����������
        for(int i = 0; i < 10; i++) {
            try {
            	Class.forName(driver);//������������
                // 2��ͨ�� JDBC �������ݿ�����
            	Connection c = DriverManager.getConnection(url,user,password);//�������ݿ�
            	Connection cnno = DriverManager.getConnection(url1,user1,password1);//�������ݿ�
                // 3�������Ӽ������ӳ���
                dataSources.add(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public java.sql.Connection getConnection() throws SQLException {
        // ȡ�����ӳ���һ������
        final Connection conn = dataSources.removeFirst(); // ɾ����һ�����ӷ���
        return (java.sql.Connection) conn;
    }
    // �����ӷŻ����ӳ�
    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
    }

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws SQLException {
		// 1��ʹ�����ӳؽ������ݿ�����
		MyDataSource dataSource = new MyDataSource();
		Connection conn = dataSource.getConnection();
		// 2������״̬
		Statement state = conn.createStatement();
		// 3����ѯ���ݿⲢ���ؽ��
		ResultSet result = state.executeQuery("select * from student");
		while(result.next()){
	        System.out.println(result.getString("sname"));
	    }
		// 4�������ѯ���
		/*
		 * while(result.next()){ 
		 * //System.out.println(result.getString("sname"));
		 * result.getString("sname"); }
		 */
		// 5���Ͽ����ݿ�����
		result.close();
		state.close();
		// 6���黹���ݿ����Ӹ����ӳ�
		dataSource.releaseConnection(conn);
	}
}