package web_server_v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	
	public Server() {
		try {
			System.out.println("server is loading ……");
			server = new ServerSocket(8088);
			System.out.println("server load success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void start() {
		try {
			System.out.println("wait for join");
			Socket socket = server.accept();
			System.out.println("one client join");
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String str = br.readLine();
			System.out.println("the client say:" + str);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
}
