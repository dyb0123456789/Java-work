package Client_Server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
	public static HashMap<String, PrintWriter> users= new HashMap<String,PrintWriter>();
	public static void main(String[] args) throws Exception{//һ�Զ������
		ServerSocket server = new ServerSocket(888);
		while(true){
			System.out.println("���ڵȴ�������");
			Socket socket = server.accept();
			SocketHandler handler = new SocketHandler(socket);
			Thread thread = new Thread(handler);
			thread.start();
		}
	}
}
