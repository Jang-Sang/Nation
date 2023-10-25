package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Reciever implements Runnable{
	
	private Scanner sc;
	private PrintWriter pw;
	private Socket so;
	private String msg;
	
	public Reciever(Socket so) {
		this.so = so;
		try {
			sc = new Scanner(so.getInputStream());
			pw = new PrintWriter(System.out);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				msg = sc.nextLine();
				pw.println(msg);
				pw.flush();
				if("exit".equals(msg)) {
					throw new NoSuchElementException();
				}
			}
		}catch(NoSuchElementException e) {
			System.err.println("대화가 종료 되었습니다.");
		}
		
		sc.close();
		pw.close();
		
		try {
			so.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("reciever : " + so.isClosed());
		
	}
	
}























