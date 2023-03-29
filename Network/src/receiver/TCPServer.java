package receiver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(56789);
			
			System.out.println(server.getLocalPort());
			
			//연결될때가 대기
			Socket socket = server.accept(); // 상대방과 연결된 socket을 반환하다...
			System.out.println(socket.getLocalSocketAddress()); // 현재 서버
			System.out.println(socket.getRemoteSocketAddress()); // 클라이언트 한테 들어온 정보
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			String request = dis.readUTF();
			System.out.println(request);
			
			String response = "성공!";
			dos.writeUTF(response);
			
			
			dos.close();
			dis.close();
			socket.close();
			
		}catch(SocketException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				server.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
