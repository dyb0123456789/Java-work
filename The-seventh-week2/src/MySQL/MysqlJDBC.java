package MySQL;
import java.sql.*;

public class MysqlJDBC {
	public static void main(String[] args) 
	{
		String driver ="com.mysql.jdbc.Driver";//����������
		String url ="jdbc:MySQL://localhost:3306/study";//urlָ��Ҫ���ʵ����ݿ�study
		String user ="root";//MySQL����ʱ���û���
		String password ="123456";//MySQL����ʱ������
		try
		{
			Class.forName(driver);//������������
			Connection c =DriverManager.getConnection(url,user,password);//�������ݿ�
			if(!c.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement =c.createStatement();//�������ݿ�
			String sql ="select * from student";//Ҫִ�е�sql���
			ResultSet rs=statement.executeQuery(sql);
			System.out.println("-----------------------------------");
			System.out.println("ѧ��"+"\t"+"����"+"\t"+"����"+"\t"+"��ַ");
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
