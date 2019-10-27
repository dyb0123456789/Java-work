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
    // 因为 LinkedList 是用链表实现的,对于增删实现起来比较容易
    LinkedList<Connection> dataSources = new LinkedList<Connection>();
    String driver ="com.mysql.jdbc.Driver";//驱动程序名
	String url ="jdbc:MySQL://localhost:3306/study";//url指向要访问的数据库study
	String user ="root";//MySQL配置时的用户名
	String password ="123456";//MySQL配置时的密码
	
	//Sqlserver
	String url1 ="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=study;";//url指向要访问的数据库study
	String user1 ="sa";//MySQL配置时的用户名
	String password1 ="123456";//MySQL配置时的密码
    public MyDataSource() {
        // 问题：每次new MyDataSource 都会建立 10 个链接，可使用单例设计模式解决此类问题
        for(int i = 0; i < 10; i++) {
            try {
            	Class.forName(driver);//加载驱动程序
                // 2、通过 JDBC 建立数据库连接
            	Connection c = DriverManager.getConnection(url,user,password);//连接数据库
            	Connection cnno = DriverManager.getConnection(url1,user1,password1);//连接数据库
                // 3、将连接加入连接池中
                dataSources.add(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public java.sql.Connection getConnection() throws SQLException {
        // 取出连接池中一个连接
        final Connection conn = dataSources.removeFirst(); // 删除第一个连接返回
        return (java.sql.Connection) conn;
    }
    // 将连接放回连接池
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
		// 1、使用连接池建立数据库连接
		MyDataSource dataSource = new MyDataSource();
		Connection conn = dataSource.getConnection();
		// 2、创建状态
		Statement state = conn.createStatement();
		// 3、查询数据库并返回结果
		ResultSet result = state.executeQuery("select * from student");
		while(result.next()){
	        System.out.println(result.getString("sname"));
	    }
		// 4、输出查询结果
		/*
		 * while(result.next()){ 
		 * //System.out.println(result.getString("sname"));
		 * result.getString("sname"); }
		 */
		// 5、断开数据库连接
		result.close();
		state.close();
		// 6、归还数据库连接给连接池
		dataSource.releaseConnection(conn);
	}
}