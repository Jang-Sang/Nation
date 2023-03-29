package variable;

import java.lang.*;

public class Test06 {

	public static void main(String[] args) {
		
		
		//문자열 - String - ???byte - 참조형
		// - 자바에서 문자열을 총괄하는 클래스(사용자 정의 자료형)
		
		String name="김민준";
		
		System.out.println(name);
		
		name = "Kim Min Jun";
		
		System.out.println(name);
		
//		System.out.println(name.toLowerCase());
//		System.out.println(name.length());
//		System.out.println(name.charAt(0));

		// 기본적으로 문자열은 연산 불가
		// 단, 문자열을 더하기가 가능하다...
		
		System.out.println(name + 100);
		System.out.println(name + (100 + 200));
		System.out.println(100 + 200 + name);
		
	}
	
}















































