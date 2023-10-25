package multi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientThread extends Thread {

	Socket so;
	Scanner sc;
	PrintWriter pw;
	
	public ClientThread(Socket so, Scanner sc, PrintWriter pw) {
		this.so = so;
		this.sc = sc;
		this.pw = pw;
	}
	
	@Override
	public void run() {
		String msg = "";
		while(true) {
			try {
				msg = sc.nextLine();
				if("exit".equals(msg)) { 
					break;
				}
				Server.sendMessage(msg); 	// 리스트에 들어온 모든 pw객체에 메시지를 전달
				
			} catch(NoSuchElementException e) {
				Server.plist.remove(pw);
				System.out.println("현재 접속자 수 : " + (Server.plist.size() - 1));
				break;
			} 
		}	// end of while
		System.out.println(so.getInetAddress() + " 스레드 종료 !!");
		sc.close();
		pw.close();
		try {	so.close();		} catch (IOException e) {}
	
	}
}
