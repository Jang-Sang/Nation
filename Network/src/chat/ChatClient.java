package chat;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {
	
	public static void main(String[] args) {
		
		try(Socket so = new Socket("192.168.12.61",23232);){
			
			new Thread(new Sender(so)).start();
			new Reciever(so).run();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
