package ifelse;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		//System.currentTimeMillis()
		// - 1970년 1월 1일 0시 0분 0초 부터 지금까지의 시간을 미리언초단위로 반환 하는 메소드
		// - 1000ms == 1s
		
		long a = System.currentTimeMillis(); //ms
		long b = a / 1000; //s
		long c = b / 60; //m
		long d = c / 60; //h
		long e = d / 24; //d
		long f = e / 365; // y
		long g = f + 1970;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		
		int sy = (int)(System.currentTimeMillis()/1000/60/60/24/365) + 1970;
		
		
//		[문제] Test02.java에 구현
//
//		사용자에게 출생년도 4자리를 입력받으시고 나이를 계산해서 화면에 출력
//			2003년생 → 20살
//			1995년생 → 26살
//			n     년생 → ?살
//
//		나이가 20살 이상이면 성인입니다! 출력
//		나이가 20살 미만이면 미성년자입니다! 출력

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출생년도 입력 : ");
		int year = sc.nextInt();
		
		int age = sy - year + 1;
		
		if(age >= 20) {
			System.out.println("성인");
		}else {
			System.out.println("미성년자");
		}
		
	}

}
