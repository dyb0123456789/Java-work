package ClientServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1",888);
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer_reader = new BufferedReader(reader);
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		String readline = "Hello!";
		writer.println(readline);
		writer.flush();
		String response = buffer_reader.readLine();
		System.out.println("Server say:"+ response);
		writer.close();
		buffer_reader.close();
		socket.close();
	}

}
