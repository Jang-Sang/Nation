package variable;

import java.lang.*;

public class Test05 {

	public static void main(String[] args) {
		
		//문자형
		// char 	2byte		0 ~ 65535
		// - ''안에 적어야한다.
		
		//문자체계
		// - 컴퓨터는 정수밖에 처리할수 없다...
		// - 문자를 처리하기 위해서 문자마다 고유한 정수값을 정해 놓았다.
		// - 문자 사용시 컴퓨터 내부에서 문자에 맞는 정수값으로 저장한다...
		// - 아스키코드 , 유니코드
		
		// - 아스키코드 - C계열의 언어
		//  - 0 ~ 127까지의 총 128가지의 문자를 처리하기위해서 만들어진 문자 체계..
		//  - 영문자 , 숫자 , 특수기호 , 제어문자..
		//  - 키보드의 키값
		//  - 1byte의 문자 체계
		
		// - 유니코드 - JAVA , Python
		//  - 아스키코드 + 이세상의 모든 문자 - 약 6만개...
		//  - 2byte의 문자 체계
		//  - 현재 가장 널리 쓰이는 문자 체계.
		
		char ch = 'A';
		
		System.out.println("ch = " + ch);
		System.out.println((int)ch);
		
		ch = '가';
		
		System.out.println(ch);
		System.out.println((int)ch);
	}
	
}

























