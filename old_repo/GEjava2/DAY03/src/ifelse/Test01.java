package ifelse;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Java점수 입력 : ");
		int java = sc.nextInt();
		
		System.out.print("Python점수 입력 : ");
		int python = sc.nextInt();
		
		System.out.println("===============================");
		
		int sum = java + python;

		
		
		System.out.println("성적합계 : " + sum + "점, 평균 : " + sum / 2.0);

		
		if(java > python) {
			System.out.println("JAVA");
		} else if(java < python) {
			System.out.println("Python");
		} else {
			System.out.println("같다");
		}
		
		
//		if(java > python) {
//			System.out.println("JAVA");
//		}else {
//			System.out.println("Python");
//		}
		
		
//		if(java > python) {
//			System.out.println("JAVA");
//		}
//		
//		if(java < python) {
//			System.out.println("Python");
//		}
		
	}
	
}






















