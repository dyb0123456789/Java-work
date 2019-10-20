package MySQL;
import java.sql.*;

public class MysqlJDBC {
	public static void main(String[] args) 
	{
		String driver ="com.mysql.jdbc.Driver";//驱动程序名
		String url ="jdbc:MySQL://localhost:3306/study";//url指向要访问的数据库study
		String user ="root";//MySQL配置时的用户名
		String password ="123456";//MySQL配置时的密码
		try
		{
			Class.forName(driver);//加载驱动程序
			Connection c =DriverManager.getConnection(url,user,password);//连接数据库
			if(!c.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement =c.createStatement();//操作数据库
			String sql ="select * from student";//要执行的sql语句
			ResultSet rs=statement.executeQuery(sql);
			System.out.println("-----------------------------------");
			System.out.println("学号"+"\t"+"姓名"+"\t"+"年龄"+"\t"+"地址");
			System.out.println("-----------------------------------");
			while(rs.next()){
				String name = rs.getString("sname");
				String age = rs.getString("age");
				String address = rs.getString("address");
				System.out.println(rs.getString("sno")+"\t"+name+"\t"+age+"\t"+address);
			}
			rs.close();
			c.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Sorry,can not find the Driver!");
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
			} 
	}
}
