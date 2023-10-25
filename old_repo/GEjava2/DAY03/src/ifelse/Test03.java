package ifelse;

import java.util.Scanner;

public class Test03 {

	
	public static void main(String[] args) {
		
//		[문제] Test03.java에 구현
//
//		중국집 주문 프로그램
//
//		사용자에게 자장면, 짬뽕 주문 수량을 입력받아 결재 금액을 계산하여 출력
//
//		자장면 	- 5000원
//		짬뽕	- 6000원
//
//		5그릇 이상 주문하면 3천원 할인되도록 금액을 계산하여 출력해주세요
//		10그릇 이상 주문하면 10% 할인 처리

		Scanner sc = new Scanner(System.in);
		
		int bp = 5000;//자장면 가격
		int rp = 6000;//짬뽕 가격
		
		int cnt1 = 10; //할인 카운트1
		int cnt2 = 5; //할인 카운트2
		
		int rate1 = 10;
		int rate2 = 3000;
		
		System.out.print("자장면 개수 입력 : ");
		int black = sc.nextInt();
		
		System.out.print("짬뽕 개수 입력 : ");
		int red = sc.nextInt();
		
		int tot = black + red;
		int price = (black * bp) + (red * rp);
		
		if(tot >= cnt1) {
			System.out.println(cnt1 + "그릇 이상 주문하면 " + rate1 + "% 할인 처리");
			System.out.println("총 금액 : " + ((int)(price * (100 - rate1) / 100.0)));
		}else if(tot >= cnt2) {
			System.out.println(cnt2 + "그릇 이상 주문하면 " + rate2 + "원 할인");
			System.out.println("총 금액 : " + (price - rate2));
		}else {
			System.out.println("총 금액 : " + price);			
		}
	}
	
}




















