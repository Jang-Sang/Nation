package operator;

import java.lang.*;

public class Test01 {

	public static void main(String[] args) {
		
		// = (대입연산자) - 덮어쓰기
		// - 우측공간의 값을 좌측 공간에 대입하는 연산자.
		
		int a = 1;
		
		a = 1;
		
		a = 1;
		
		
		// 복합대입연산자 - 누적
		// - 우측 공간의 값을 산술연산을 통하여 좌측 공간의 값을 대입하는 연산자.
		
		// +=		a+=b			a = a + b
		
		// -=		a-=b			a = a - b
		
		// *=		a*=b			a = a * b
		
		// /=		a/=b			a = a / b
		
		// %=		a%=b			a = a % b
		
		a+=1;
		
		System.out.println(a);
		
		a+=1;
		
		System.out.println(a);
	}
	
}
