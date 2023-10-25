package forloop;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) throws InterruptedException {
//		[문제] Test04.java에 구현
//		타이머 만들기
//		사용자에게 분을 입력받아서 해당하는 시간이 흐른 뒤 메세지가 출력되도록 코드구현
//		(예상결과)		
//		분 입력 : 3
//		3분 0초 남음
//		2분 59초 남음
//		...
//		0분 2초 남음
//		0분 1초 남음
//		0분 0초 남음
//		정신차려 이놈자식아!!!!
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("분 입력 : ");
		int min = sc.nextInt();
		
		for(int s = min * 60; s >= 0; s--) {
			System.out.println(String.format("%02d분 %02d초 남음", s/60,s%60));
			Thread.sleep(1000);
			//내가 지정한 시간 만큼 프로그램을 멈추어 주는 메소드
			//ms단위로 적어주면 된다....
		}
		
		
		//sc.close();

	}

}




















