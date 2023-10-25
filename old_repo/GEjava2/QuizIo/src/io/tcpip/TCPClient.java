package io.tcpip;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {

	public static void main(String[] args) {
		
		//TCP - Socket , ServerSocket
		Socket socket = null;
		try {
			socket = new Socket("192.168.123.20",21212);
			//상대방과 1:1로 연결이 유지되는 객체이기때문에...
			//객체 생성에 성공 하게 되면 상대방과 연결되었다라는 뜻이다...
			System.out.println(socket.getLocalPort());
			
			//TCP에서의 IO
			// OutputStream , InputStream을 통해서 데이터를 주고 받는다...
			InputStream is = socket.getInputStream(); // 데이터를 받는 객체
			OutputStream os = socket.getOutputStream(); // 데이터를 보내는 객체
			
			//DataIN,Out | ObjectIn , Out | BufferedReader,BufferedWriter | PrintWriter,Scanner로 변형시켜
			//데이터를 주고 받을수 있다...
			
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			
			String request = "김민준"; //요청
			dos.writeUTF(request);
			System.out.println(request);
			
			String response = dis.readUTF(); //응답
			System.out.println(response);
			
			dos.close();
			dis.close();
			
		}catch(SocketException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}













































