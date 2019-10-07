package Client_Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SocketHandler implements Runnable {
	private Socket socket;
	Scanner input=new Scanner(System.in);
	public SocketHandler(Socket socket){
		this.socket = socket;		
	}
	@SuppressWarnings("unchecked")
	public void run(){
		try {
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer_reader=new BufferedReader(reader);
		PrintWriter writer=new PrintWriter(socket.getOutputStream());
		String client = "<" + socket.getInetAddress().toString() + " : " + socket.getPort() + ">";
		boolean f=true;
		while(f){
			String request = buffer_reader.readLine();
			
			if(request.startsWith("<register "))//<register name=��xu��/> ע��
			{ 
				String name="";
				for(int i=0;i<request.length();i++){//�õ��û���
					if(request.charAt(i)=='��'){
						for(int j=i+1;j<request.length();j++){
							if(request.charAt(j)=='��'){
							   i=j+1;
							   break;	
							}
							name=name+String.valueOf(request.charAt(j));
						}
						break;
					}
				}
				Server.users.put(name, writer);//�洢д��ͼ��
				
				if(name.equals("")){
				    writer.println("<result ʧ��>");
				}else{
					writer.println("<result ע��ɹ���>");
				}		
			}else if(request.startsWith("<login "))//<login name=��xu��/>��¼
			{
				String userName="";
				for(int i=0;i<request.length();i++){//�õ��û���
					if(request.charAt(i)=='��'){
						for(int j=i+1;j<request.length();j++){
							if(request.charAt(j)=='��'){
							   i=j+1;
							   break;	
							}
							userName=userName+String.valueOf(request.charAt(j));
						}
						break;
					}
				}
				if(userName.equals("")){
				    writer.println("<result ʧ��>");
				}else{
					writer.println("<result ��¼�ɹ���>");
				}		
			}
			else if(request.startsWith("<message")) //����ת�� ��Ϣmessage from="xu" to="zhang" message="ddd" />
			{
				int count=0;//������  
				String toName="";//�õ��ռ��˵�����
				String message="";//�õ����͵���Ϣ
				
				for(int i=0;i<request.length();i++){//�õ�Message���������
					if(request.charAt(i)=='��'){
						count++;
						if(count==3){//�õ���һ�ͻ��˵�����
							for(int j=i+1;j<request.length();j++){
								if(request.charAt(j)=='��'){
								   count++;
								   i=j+1;
								   break;	
								}
								toName=toName+String.valueOf(request.charAt(j));//�ռ��˵�����
							}
						}
						if(count==5){//�õ����͵���һ�ͻ��˵���Ϣ
							for(int j=i+1;j<request.length();j++){
								if(request.charAt(j)=='��'){
								   i=j+1;
								   break;	
								}
								
								message=message+String.valueOf(request.charAt(j));//�õ���Ϣ����
								
							}
							break;
						}						
					}
				}
				
				PrintWriter toWriter =  Server.users.get(toName); 

				if(toWriter!=null){				
					toWriter.println(message);//����һ�ͻ���д����Ϣ
					toWriter.flush();
				}else{
					writer.println("�Բ���û�д��û�������......");
				}				
			} else if(request.startsWith("<logout"))//�˳���¼//<logout from ="xu" />
			{
				String name="";
				for(int i=0;i<request.length();i++){//�õ��û���
					if(request.charAt(i)=='��'){
						for(int j=i+1;j<request.length();j++){
							if(request.charAt(j)=='��'){
							   i=j+1;
							   break;	
							}
							name=name+String.valueOf(request.charAt(j));
						}
						break;
				     }
		          }
				Server.users.remove(name);//ɾ���û���
				
				writer.println("<result �˳��ɹ���>");
				break;
			}else if(request.equals("update")){
				
			}else{
				writer.println("������������������");
			}
			
			writer.flush();
		}
		
		writer.close();
		buffer_reader.close();
		socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public static void FileInformation(String texts){//��ʾ�յ����ı�
			JFrame showInfo=new JFrame();
			JPanel jp=new JPanel();
			JTextArea text=new JTextArea(20,20);//�ı���
			text.append(texts+"\n");//����
			jp.add(text);
			showInfo.add(jp);
			
			showInfo.setTitle("�������Ӧ��");
			showInfo.setVisible(true);
			showInfo.setSize(300,200);
			showInfo.setLocation(500, 500);
			showInfo.setDefaultCloseOperation(1);
		}
}
