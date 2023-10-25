package sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class UDPSender { //Client

	public static void main(String[] args) {
		
		try(DatagramSocket ds = new DatagramSocket();){
			System.out.println(ds.getLocalPort());
			
			//send용 패킷
			//보내고자 하는 데이터를 byte[]로 만들어서 전송
			// 패킷 생성하고 목적지까지 설정해주어야 한다..
			String data = "김민준";
			byte[] b = data.getBytes();
			SocketAddress address = new InetSocketAddress("192.168.12.61",12121);//아이피 주소와 포트번호를 관리하는 객체
//			System.out.println(address.getHostName());
//			System.out.println(address.getHostString());
//			System.out.println(address.getAddress());
//			System.out.println(address.getPort());
			DatagramPacket packet = new DatagramPacket(b, b.length, address);
			
			//데이터 전송
			ds.send(packet);
			
			System.out.println("패킷 전송!");
			
			byte[] buf = new byte[1024];
			
			packet.setData(buf);
			
			ds.receive(packet); // 대기 상태에 있다가 실제 전달을 받으면 다음으로 넘어 간다...
			
			
			b = packet.getData(); // 전송받은 데이터를 byte 배열형태로 반환 해준다...
			
			System.out.println(b.length);
			System.out.println(packet.getLength());
			
			System.out.println(new String(b,0,packet.getLength()));
			
		}catch(SocketException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
