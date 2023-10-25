package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {
		
		try(ServerSocket ss = new ServerSocket(21212);){
			
			try(Socket so = ss.accept();) {
				
				System.out.println(so.getRemoteSocketAddress());
				
				new Thread(new Sender(so)).start();
				new Reciever(so).run();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
