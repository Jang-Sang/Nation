package multi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Server {
	
	public static ArrayList<PrintWriter> plist = new ArrayList<PrintWriter>();
	
	public static void sendMessage(String str) {
		if(str == null) {
			return;
		}
		for(int i = 0; i < plist.size(); i++) {
			PrintWriter pw = plist.get(i);
			pw.println(str);
			pw.flush();
		}
	}
	
	public static void main(String[] args) {
		
		PrintWriter out = new PrintWriter(System.out);
		plist.add(out); // 서버 컴퓨터의 System.out에도 문자열이 전달될수 있도록 리스트에 추가
		
		ServerSocket ss = null;
		Socket so = null;
		PrintWriter pw = null;
		Scanner sc = null;
		String host = null;
		
		int port = 10242;
		
		try {
			ss = new ServerSocket(port);
			
			while(true) {
				System.out.println("접속대기중...(" + (plist.size() - 1) + ")");
				
				so = ss.accept();
				
				host = so.getInetAddress().getHostAddress();
				host += ":" + so.getPort();
				
				sendMessage(host + "님이 접속하셨습니다.");
				
				sc = new Scanner(so.getInputStream());
				pw = new PrintWriter(so.getOutputStream());
				
				ClientThread ct = new ClientThread(so,sc,pw);
				
				ct.start();
				
				System.out.println(host + "님에게 보낼수 있는 스트림을 plist에 추가합니다.");
				plist.add(pw);
			}
		}catch(BindException e) {
			System.err.println("이미 포트를 사용중입니다. " + port);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			for(PrintWriter p : plist) {
				p.close();
			}
			plist.clear();
			try {if(pw != null) pw.close();}catch(Exception e) {e.printStackTrace();}
			try {if(so != null) so.close();}catch(Exception e) {e.printStackTrace();}
			try {if(ss != null) ss.close();}catch(Exception e) {e.printStackTrace();}
		}
		
	}
}






















































