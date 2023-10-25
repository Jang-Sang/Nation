package receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

// 통신 방식
// UDP - 무전기 , 개인쪽지 - 비연결형
// TCP - 핸드폰 , 개인채팅 - 연결형

public class UDPReceiver { //server

	public static void main(String[] args) {
		
		// UDP 방식으로
		// 원격으로 컴퓨터로 부터 데이터를 전송받아서 그 전송 받은 데이터를 확인.
		
		// DatagramSocket : 메신저 역할
		// DatagramPacket : 문자 역할
		DatagramSocket socket = null;
		
		try {
			socket = new DatagramSocket(12121); // 1 ~ 65535
			//디폴트 생성자로 생성시엔 포트번호를 알아서 생성된다...
			//이미 사용중이거나 없는 포트번호면 SocketException 이 발생된다...
			
			int port = socket.getLocalPort();
			
			System.out.println(port);
			
			while(true) {
				//받는 작업... DatagramPacket
				byte[] b = new byte[1024];
				DatagramPacket packet = new DatagramPacket(b, b.length);// 패킷 생성...
				
				System.out.println("수신 대기");
				
				//받기
				socket.receive(packet); // 대기 상태에 있다가 실제 전달을 받으면 다음으로 넘어 간다...
				
				SocketAddress addr = packet.getSocketAddress();
				System.out.println(addr);
				
				b = packet.getData(); // 전송받은 데이터를 byte 배열형태로 반환 해준다...
				
				System.out.println(new String(b));
				
				b = "수신 성공".getBytes();
				
				System.out.println(b.length);
				packet.setData(b);
				
				socket.send(packet);
			}
			
			
			
			
		}catch(SocketException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(socket != null) {
				socket.close();
			}
		}
	}
	
}

















