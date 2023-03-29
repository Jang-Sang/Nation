package whileloop;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
//		[문제] Test03.java에 구현
//
//		업다운 게임을 구현하려 합니다.
//		컴퓨터에게 1부터 100 사이의 정답을 생성하도록 코드를 구현한 뒤
//		사용자가 숫자를 입력하여 정답을 맞추도록 프로그래밍하세요
//
//		<게임의 상태>
//		[   업  ] 사용자가 정답보다 낮은 값을 입력한 경우
//		[ 다운 ] 사용자가 정답보다 높은 값을 입력한 경우
//		[ 정답 ] 사용자가 정답과 같은 값을 입력한 경우, 게임 종료
//
//		게임 종료시 총 입력한 횟수를 화면에 출력
		
		
		Scanner sc = new Scanner(System.in);
		
		int com = (int)(Math.random() * 100) + 1;
		
		int cnt = 0;
		
		while(true) {
			
			System.out.print("정수 입력 : ");
			int user = sc.nextInt();
			
			cnt++;
			
			if(user > com) {
				System.out.println("[다운]");
			}else if(user < com) {
				System.out.println("[업]");
			}else {
				System.out.println("[정답]");
				System.out.println("총 입력횟수 : " + cnt + "번");
				break;
			}
		}
		
		
	}

}


















