package Data_processing;

import java.sql.*;

public class Connection {
	public static void main(String[] args) 
	{
		String driver ="com.mysql.jdbc.Driver";//驱动程序名
		String url ="jdbc:MySQL://localhost:3306/study";//url指向要访问的数据库study
		String user ="root";//MySQL配置时的用户名
		String password ="123456";//MySQL配置时的密码
		long time1 = System.currentTimeMillis();
		try
		{
			Class.forName(driver);//加载驱动程序
			java.sql.Connection c = DriverManager.getConnection(url,user,password);//连接数据库
			if(!c.isClosed())                         //当isClose返回false，isConnected返回true的时候Socket对象才处于连接状态
				System.out.println("Succeeded connecting to the Database!"); 
			for(int i=0;i<50;i++)
			{
			  Statement statement =c.createStatement();//操作数据库
			  String sql ="select * from student";//要执行的sql语句
			  ResultSet rs=statement.executeQuery(sql); //执行这条数据库语言
			rs.close();
			}
			c.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Sorry,can not find the Driver!");
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
			} 
		long time2 = System.currentTimeMillis();
		System.out.println("连接处理数据50次用时："+(time2-time1)+"毫秒");
	}
}
