package input;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
//		[문제] Test02.java에 구현
//
//		앞의 예제를 참고하시어 사용자에게 입력을 받아 다음을 계산하시오
//
//		(결과 화면)	
//		자바 시험 점수 입력하세요
//		95
//		파이썬 시험 점수 입력하세요
//		80
//		이름을 입력하세요
//		홍길동
//		============================
//		홍길동님의 성적 합계 = 175점, 평균 = 87.5		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Java점수 입력 : ");
		int java = sc.nextInt();
		
		System.out.print("Python점수 입력 : ");
		int python = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.println("===============================");
		
		int sum = java + python;
		//double avg = sum / 2.0;
		
		
		System.out.println(name + "님의 성적합계 : " + sum + "점, 평균 : " + sum / 2.0);
	}	
	
}




















