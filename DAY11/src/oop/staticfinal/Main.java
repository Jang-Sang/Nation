package oop.staticfinal;

import java.awt.Color;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//static final - 심볼릭상수 - 상수화 변수
		// - 변수공간의 데이터를 변경할수 없는 변수...
		// - 프로그램이 실행하면서 공간이 만들어지고 프로그램이 끝날때 공간이 소멸된다...
		// - 프로그램 전체적으로 사용되고 그 값이 변경되지 않고 프로그램에서 의미를 가지고 있는
		//   데이터를 저장하여 보다 쉽게 구분하여 사용하기 위해서...
		// - 변수명은 대문자를 권장한다....
		
		
		System.out.println(3.141592);
		System.out.println(Math.PI);
		System.out.println(2147483647);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Color.BLACK);
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키 입력 : ");
		String key = sc.next();
		
		// q w e r
		
		switch(key) {
		case Key.SKILL1:
			System.out.println("SKILL1");
			break;
		case Key.SKILL2:
			System.out.println("SKILL2");
			break;
		case Key.SKILL3:
			System.out.println("SKILL3");
			break;
		case Key.SKILL4:
			System.out.println("SKILL4");
			break;
		default:
			System.out.println("잘못된 키 입력!!");
		}
		
		
	}
	
}
