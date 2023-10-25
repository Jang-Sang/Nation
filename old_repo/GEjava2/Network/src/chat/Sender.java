package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class Sender implements Runnable{

	public static Scanner sc;
	private PrintWriter pw;
	private Socket so;
	private String msg;
	
	public Sender(Socket so) {
		this.so = so;
		try {
			sc = new Scanner(System.in);
			pw = new PrintWriter(so.getOutputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			msg = sc.next();
			pw.println(msg);
			pw.flush();
			
			if("exit".equals(msg)) {
				break;
			}else if(so.isClosed()) {
				break;
			}
		}
		
		sc.close();
		pw.close();
		
		try {
			so.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("sender : " + so.isClosed());
		
	}
}

















