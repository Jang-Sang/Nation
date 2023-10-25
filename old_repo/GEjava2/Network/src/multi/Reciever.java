package multi;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Reciever implements Runnable{
	
	private Scanner sc;
	private Socket so;
	private String msg;
	
	public Reciever(Socket so) {
		this.so = so;
		try {
			sc = new Scanner(so.getInputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				msg = sc.nextLine();
				if("exit".equals(msg)) {
					throw new NoSuchElementException();
				}else if(msg==null) {
					throw new NoSuchElementException();
				}
				System.out.println(msg);
			}
		}catch(NoSuchElementException e) {
			System.err.println("대화가 종료 되었습니다.");
		}
		
		sc.close();
		
		try {
			so.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("reciever : " + so.isClosed());
		
	}
	
}























