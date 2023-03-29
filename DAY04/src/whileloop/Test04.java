package whileloop;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
//		[문제] Test04.java에 구현
//
//		사용자가 틀릴 때까지 구구단 문제를 출제하는 프로그램 구현
//			(2 x 1 부터 19 x 9까지 구현)
//
//		사용자가 3문제를 틀리면 게임오버! 라는 메세지를 출력한 뒤 종료
//		종료 전에 정답 개수와 점수를 출력
//
//		[1] 일반 정답 +10점
//		[2] 어려운 문제 정답은 5점 추가 (총 15점)		11단부터~		
		
		Scanner sc = new Scanner(System.in);
			
		int over = 2;
		int cnt = 0;
		int sum = 0;
		
		while(true) {
			int a = (int)(Math.random() * 14) + 2;
			int b = (int)(Math.random() * 9) + 1;
			
			System.out.print(a + " × " + b + " = ");
			int user = sc.nextInt();
			
			int com = a * b;
			
			if(com == user) {
				System.out.println("정답! 10점 획득!");
				sum += 10;
				cnt++;
				if(a >= 11) {
					sum += 5;
					System.out.println("어려운 문제 정답! 추가 5점 획득!");
				}
			}else {
				System.out.println("오답! 5점 감점!");
				sum -= 5;
				if(over == 0) {
					System.out.println("게임 오버!");
					System.out.println("총 정답 개수 : " + cnt + "개\t총 점수 : " + sum + "점");
					break;
				}
				System.out.println("오답! " + over + "번 남았습니다.");
				over--;
			}
		}
	}
	
}
