package dowhile;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int su = 0;

		do {
			System.out.print("10 ~ 20 사이의 숫자 입력 : ");
			su = sc.nextInt();
		}while(su < 10 || su > 20);
		
//		while(true) {
//			System.out.print("10 ~ 20 사이의 숫자 입력 : ");
//			su = sc.nextInt();
//			if(su >= 10 && su <=20) {
//				break;
//			}else {
//				System.out.println("10 ~ 20 사이의 숫자만 입력!");
//			}
//		}
		
			
		int i = 1;
		int sum = 0;
		while(i <= su) {
			sum += i;
			i++;
		}
		
		System.out.println("총 합 : " + sum);
		
	}

}
