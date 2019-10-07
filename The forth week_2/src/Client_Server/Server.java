package Client_Server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
	public static HashMap<String, PrintWriter> users= new HashMap<String,PrintWriter>();
	public static void main(String[] args) throws Exception{//一对多的聊天
		ServerSocket server = new ServerSocket(888);
		while(true){
			System.out.println("正在等待。。。");
			Socket socket = server.accept();
			SocketHandler handler = new SocketHandler(socket);
			Thread thread = new Thread(handler);
			thread.start();
		}
	}
}
