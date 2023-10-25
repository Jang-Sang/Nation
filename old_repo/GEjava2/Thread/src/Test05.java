import javax.swing.JOptionPane;

class Worker extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i <= 10000000; i++) {
			boolean t = isInterrupted(); // Thread 상태 확인
			System.out.println(i + "실행중..." + t);
			if(t) {
				break;
			}
		}
	}
}

public class Test05 {
	
	public static void main(String[] args) {
	
		Worker w = new Worker();
		
//		w.setDaemon(true);
		// 디폴트 값은 false, true로 설정하고 start를 걸면
		// 자신을 제외한 가동중인 쓰레드가 없으면 종료가 된다...
		
		w.start();
		
		try {
			while(true) {
				String cmd = JOptionPane.showInputDialog("명령 입력 : ");
				switch(cmd) {
				case "start":
					w.start(); // start를 두번 하게 되면 java.lang.lllegalThreadStateException
					break;
				case "interrupt":
					w.interrupt(); // Thread 강제 종료
					break;
				case "join":
					//w.join(); //해당 쓰레드의 작업이 끝나길 기다리는 메소드(다른 쓰레드에 일시 정지가 걸린다...)
					w.join(2000);
					break;
				case "suspend":
					w.suspend();//일시정지
					break;
				case "resume":
					w.resume(); // 다시 시작
					break;
				case "stop":
					w.stop(); // 종료
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}




















