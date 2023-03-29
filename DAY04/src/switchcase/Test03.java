package switchcase;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {

//		 -계산기 만들기
//
//		 두개의 정수를 입력받고 다음과 같이 사칙연산을 할수 있는 
//		 switch문을 만들어 출력 하십시오.
//
//		 ================출력===============
//
//		 ## 계산기 ##
//		 1.더하기
//		 2.빼기
//		 3.나누기
//		 4.곱하기
//		 선택 : 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연산할 정수 입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.print("## 계산기 ## \r\n" + 
				"1.더하기     \r\n" + 
				"2.빼기      \r\n" + 
				"3.나누기     \r\n" + 
				"4.곱하기     \r\n" + 
				"선택 : ");
		int select = sc.nextInt();
		
		switch(select) {
		case 1:
			System.out.println(a + " + " + b + " = " + (a + b));
			break;
		case 2:
			System.out.println(a + " - " + b + " = " + (a - b));
			break;
		case 3:
			System.out.println(a + " ÷ " + b + " = " + (a / (double)b));
			break;
		case 4:
			System.out.println(a + " × " + b + " = " + (a * b));
			break;
		default:
			System.out.println("잘못된 입력!");			
		}

	}

}















