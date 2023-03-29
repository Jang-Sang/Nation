// Thread
// - 두개 이상의 코드를 동시에 실행할수 있도록 만드는 것...
// - 구현 방식
//  - Thread 클래스 상속
//  - Runnable 인터페이스 상속
//  - 익명 중첩 클래스

class CharPrint extends Thread{
	char start;
	char end;
	
	public CharPrint(char start,char end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() { // Thread가 실행하는동안 실행되는 코드를 적는 메소드
		char c = start;
		while(c < end) {
			String str = "";
			for(int i = 1; i <= 20; i++) {
				str += c++;
				if(c == end) {
					break;
				}
			}
			synchronized (System.out) { //동기화 - 하나의 쓰레드가 접근하고 있으면 다른쓰레드에서는 접근 불가..
				System.out.println(getName() + " : " + str);
			}
		}
	}
}

public class Test01 {

	public static void main(String[] args) {
		
//		for(char c = '가'; c < '나'; c++) {
//			System.out.print(c);
//		}
//		System.out.println();
//		for(char c = '나'; c < '다'; c++) {
//			System.out.print(c);			
//		}
		
		Thread t1 = new CharPrint('가', '나');
		t1.start(); // 실행 - run 메소드 실행
		Thread t2 = new CharPrint('나', '다');
		t2.start();
	
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		for(int i = 1; i <= 10; i++) {
			System.out.println("--");
		}
		
//		t1.stop();
//		t1.resume();
		
	}
	
}




















