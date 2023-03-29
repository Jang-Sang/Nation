package array;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) throws InterruptedException {

//				[문제] Test03.java 에 구현
//				선택장애 치료 프로그램
//
//				사용자에게 5가지 항목을 입력받아 배열에 저장
//				무작위로 1가지를 추첨하여 화면에 출력
//
//				(예)   항목 : 김밥
//					   항목 : 라면
//					   항목 : 떡볶이
//					   항목 : 자장면
//				   	   항목 : 순대국
//				  	   추첨중입니다....
//				   	   추첨된 항목은 떡볶이 입니다
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("항목 개수 입력 : ");
		int su = sc.nextInt();
		
		String[] arr = new String[su];
		
		sc.nextLine();
		
		for(int i = 0; i < su; i++) {
			System.out.print("항목 : ");
			arr[i] = sc.nextLine();
		}
		
		System.out.print("추첨중입니다.");
		for(int i = 0; i < 5; i++) {
			Thread.sleep(500);
			System.out.print(".");
		}
		
		int pick = (int)(Math.random() * su);
		
		System.out.println("\n추첨된 항목은 " + arr[pick] + "입니다.");
		
		sc.close();
	}

}
