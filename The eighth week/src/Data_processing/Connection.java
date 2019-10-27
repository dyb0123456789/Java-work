package Data_processing;

import java.sql.*;

public class Connection {
	public static void main(String[] args) 
	{
		String driver ="com.mysql.jdbc.Driver";//����������
		String url ="jdbc:MySQL://localhost:3306/study";//urlָ��Ҫ���ʵ����ݿ�study
		String user ="root";//MySQL����ʱ���û���
		String password ="123456";//MySQL����ʱ������
		long time1 = System.currentTimeMillis();
		try
		{
			Class.forName(driver);//������������
			java.sql.Connection c = DriverManager.getConnection(url,user,password);//�������ݿ�
			if(!c.isClosed())                         //��isClose����false��isConnected����true��ʱ��Socket����Ŵ�������״̬
				System.out.println("Succeeded connecting to the Database!"); 
			for(int i=0;i<50;i++)
			{
			  Statement statement =c.createStatement();//�������ݿ�
			  String sql ="select * from student";//Ҫִ�е�sql���
			  ResultSet rs=statement.executeQuery(sql); //ִ���������ݿ�����
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
		System.out.println("���Ӵ�������50����ʱ��"+(time2-time1)+"����");
	}
}
