package Book_Test;

import java.sql.DriverManager;

import Data_processing.Connection;

public class MySqlDAO {
	public static Connection getConnection() throws Exception{
		String driverName = "com.mysql.jdbc.Driver";//����������
		String url = "jdbc:MySQL://localhost:3306/study";//urlָ��Ҫ���ʵ����ݿ�study
		String userName ="root";//MySQL����ʱ���û���
		String password ="123456";//MySQL����ʱ������
		Class.forName(driverName);
		java.sql.Connection con = DriverManager.getConnection(url,userName,password);//�������ݿ�
		return (Connection) con;
	}
}
