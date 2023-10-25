package whileloop;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
//		10~20사이의 숫자만 입력 받아 1부터 
//	    입력 받은 수까지의 합을 구하시오

		Scanner sc = new Scanner(System.in);
		
		//지역변수
		// - 어느 한 지역에 속해서 그 지역내에서 우선적으로 사용되는 변수
		// - 지역이 실행할때 공간이 생성되고 그 지역이 끝날때 공간이 소멸된다...
		
		int su = 0;
		
		while(true) {
			System.out.print("10 ~ 20 사이의 숫자 입력 : ");
			su = sc.nextInt();
			if(su >= 10 && su <=20) {
				break;
			}else {
				System.out.println("10 ~ 20 사이의 숫자만 입력!");
			}
		}
		
			
		int i = 1;
		int sum = 0;
		while(i <= su) {
			sum += i;
			i++;
		}
		
		System.out.println("총 합 : " + sum);
		
		
//		System.out.print("10 ~ 20 사이의 숫자 입력 : ");
//		int su = sc.nextInt();
//		
//		if(su >= 10 && su <= 20) {
//			
//			int i = 1;
//			int sum = 0;
//			while(i <= su) {
//				sum += i;
//				i++;
//			}
//			
//			System.out.println("총 합 : " + sum);
//			
//		}else {
//			System.out.println("잘못된 입력!");
//		}
		
	}

}
