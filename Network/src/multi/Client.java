package multi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc = null;
		PrintWriter pw = null;
		Socket so = null;
		String msg = "";
		
		try {
			so = new Socket("192.168.12.61",10242);
			sc = new Scanner(System.in);
			pw = new PrintWriter(so.getOutputStream());
			
			new Thread(new Reciever(so)).start();
			
			String id = null;
			System.out.print("ID를 입력하세요 : ");
			id = sc.nextLine();
			pw.println("\n\t[" + id + "] 님이 대화에 참여합니다\n");
			pw.flush();
			
			System.out.println("=== 채팅 시작 ===\n");
			
			while(true) {
				msg = sc.nextLine();
				if("exit".equals(msg)) {
					System.out.println("프로그램 종료");
					pw.println("\n\t[" + id + "] 님이 대화를 종료합니다\n");
					pw.flush();
					break;
				}else if("".equals(msg) == false) {
					pw.println("[" + id + "] : " + msg);
					pw.flush();
				}
			}
		}catch(ConnectException e) {
			System.err.println("서버가 아직 준비가 되지 않았습니다.");
			System.exit(0);
		}catch(IOException e) {
			System.err.println("입출력 예외 발생 : " + e);
		}finally {
			sc.close();
			try { if(so != null) so.close();} catch(Exception e) {}
		}
		
	}
	
}

































