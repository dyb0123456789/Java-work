package Book_Test;

import java.sql.DriverManager;

import Data_processing.Connection;

public class MySqlDAO {
	public static Connection getConnection() throws Exception{
		String driverName = "com.mysql.jdbc.Driver";//驱动程序名
		String url = "jdbc:MySQL://localhost:3306/study";//url指向要访问的数据库study
		String userName ="root";//MySQL配置时的用户名
		String password ="123456";//MySQL配置时的密码
		Class.forName(driverName);
		java.sql.Connection con = DriverManager.getConnection(url,userName,password);//连接数据库
		return (Connection) con;
	}
}
