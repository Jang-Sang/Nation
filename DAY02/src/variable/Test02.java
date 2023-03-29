package variable;

import java.lang.*;

public class Test02 {

	public static void main(String[] args) {
		
		//정수형
		
		System.out.println(1);
		System.out.println(123);
		
		//정수 자료형 - int
		// - byte		1byte	-128 ~ 127					-2^7 ~ 2^7-1 - 
		// - short		2byte	-32768 ~ 32767				-2^15 ~ 2^15 - 1
		// - int		4byte	-2147483648 ~ 2147483647	-2^31 ~ 2^31 - 1
		// - long		8byte								-2^63 ~ 2^63 - 1
		
		// 1bit - 0 or 1 둘중 하나를 저장할수 있는 컴퓨터의 최소 데이터 단위
		// 1bit * 8 = 1byte
		// 1byte * 1024 = 1kb
		// 1kb * 1024 = 1mb
		// 1mb * 1024 = 1GB
		// 1GB * 1024 = 1TB
		
		int a = 20;
		
		System.out.println(a);
		
		a = 30;
		
		System.out.println(a);
		
		//※정수형 상수는 int형으로 인식된다...
		//※데이터공간이 작은것과 큰것이 함께 연산이 들어가면 
		//  데이터 공간이 큰쪽으로 따라간다..
		
		//정수형 데이터 사용시 주의 사항
		//1. 정수형 데이터는 원형이다
		
		byte b = 127;
		
		b++; //b+=1; //b = b + 1;
		
		System.out.println(b);
		
		b--; // b-=1; //b = b - 1;
		
		System.out.println(b);
		
		//2. 정수끼리의 연산에서는 정수값이 나온다...
		int c = 10;
		int d = 3;
		
		//산술연산자
		System.out.println(10 + 3); //더하기
		System.out.println(10 - 3); //빼기
		System.out.println(10 * 3); //곱하기
		System.out.println(10 / 3); //나누기 - 정수 연산시 나누기의 몫
		System.out.println(10 % 3); //나누기의 나머지
	}
	
}


















