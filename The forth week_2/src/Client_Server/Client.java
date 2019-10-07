package Client_Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Client {
	public static void main(String[] args) throws Exception{
	
		Socket socket = new Socket("127.0.0.1",888);		
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer_reader = new BufferedReader(reader);
		Scanner input= new Scanner(System.in);
	
		PrintWriter writer = new PrintWriter(socket.getOutputStream());	
		boolean f=true;//ѭ���ж�
		String name=null;//���ͷ�����
		String toName=null;//���շ�����
		int temp=0;//���ڶ�λ�Ƿ����Ѿ���������
		int i=0;
		int logout=0; //�ж��Ƿ��˳�
		
		while(f){
			 
			String str=null;
			if(i==3){
				
			}else{
				System.out.print("��ѡ��:1.ע��  2.��½  3.����Ϣ  4.�˳�:");
				i=input.nextInt();
			}
			
			 if(i==1){//ע��
				 System.out.print("��˵:");
				 String str1=input.next(); 
				 str="<register  name=��"+str1+"��/>";
				 writer.println(str);
				 writer.flush();	
				 String echo= buffer_reader.readLine();
				 System.out.println("��������Ӧ:"+echo);
			 }else if(i==2){//��½
				 System.out.print("��˵:");
				 String str1=input.next(); 
				 name=str1;
				 str="<login  name=��"+str1+"��/> ";
				 writer.println(str);
				 writer.flush();	
				 String echo= buffer_reader.readLine();
				 System.out.println("��������Ӧ:"+echo);
			 }else if(i==3){//������...
				 String message=null;
				 if(temp==0){
					 System.out.print("���ܷ�����:");
					 toName=input.next();
					 System.out.print("��˵("+name+"):");	
					 message=input.next();
					 temp=1;
				 }else{
					 System.out.print("��˵("+name+"):");	
					 message=input.next();
				 }	
				 if(message.equals("logout")){//�������logou�ʹ����˳����������
					 logout=1;
				 }else{
					 str="<message from=��"+name+"��"+" to=��"+toName+"��"+"  message=��"+message+"��>";
					 writer.println(str);
					 writer.flush();	
					 String echo= buffer_reader.readLine();//������Ϣ
					 System.out.println(toName+":"+echo);//������Ϣ
					 }			 			 
			 }
			 if(i==4||logout==1){//�˳�
				 str="<logout  name=��"+name+"��/";//�˳�
				 writer.println(str);
				 writer.flush();	
				 String response = buffer_reader.readLine();
		         System.out.println("��������Ӧ:"+ response);
				 f=false;
			 }
		 }	
		//System.out.println("��ӭ�ٴι��٣�bye");
		writer.close(); 
		buffer_reader.close(); 
		socket.close(); 
	}
	 public static void FileInformation(String texts){//��ʾ�յ����ı�
			JFrame showInfo=new JFrame();
			JPanel jp=new JPanel();
			JTextArea text=new JTextArea(20,20);//�ı���
			text.append(texts+"\n");//����
			jp.add(text);
			showInfo.add(jp);
			
			showInfo.setTitle("�ش�");
			showInfo.setVisible(true);
			showInfo.setSize(300,200);
			showInfo.setLocation(500, 500);
			showInfo.setDefaultCloseOperation(1);
	}
}