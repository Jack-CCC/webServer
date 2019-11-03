package web_server_v1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	private Socket socket;
	
	public Client() {
		try {
			System.out.println("client is loading ……");
			socket = new Socket("localhost",8088);
			System.out.println("client load successfully");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void start() {
		try {
			Scanner scanner = new Scanner(System.in);
			
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw, true);
			
			String line = null;
			
			while(true) {
				line = scanner.nextLine();
				pw.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
	
}
