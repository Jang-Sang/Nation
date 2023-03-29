package whileloop;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		//정수 입력받아서 거꾸로 출력
		
		// 12340
		
		// 04321
		
		//출력문은 하나만
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		
		int su = sc.nextInt();

		String rev = "";
		
		while(su != 0) {
			rev += (su % 10);
			su/=10;
		}
		
		System.out.println(rev);
		
	}

}
