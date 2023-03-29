package variable;

import java.lang.*;

public class Test03 {
	
	public static void main(String[] args) {
		
		//실수
		System.out.println(123.3456);
		
		//실수 자료형 - double			유효자리수
		// - float		4byte			6자리
		// - double		8byte			15자리
		
		double a = 123.456;
		
		System.out.println(a);
		
		//※ 실수형 상수는 기본적으로 double 형으로 인식된다...
		//  실수형 상수 뒤에 f를 적어주면 float형으로 인식된다...
		float b = 123.456f;
		
		//※ JAVA는 데이터 타입에 민감하다....
		// - 자료형이 작은쪽에서 큰쪽으로 갈때는 문제가 되지 않지만
		//   큰쪽에서 작은쪽으로 갈때는 에러가 발생된다...
		//   - 같은 크기라면 실수가 정수보다 크다.
		//   - 조금이라도 데이터 손실이 발생될수 있는 상황이면 에러...
		
		// double > float > long > int > short == char > byte
		
		// cast 연산자
		// - 임시적으로 내가 원하는 데이터 타입으로 형변환을 해주는 연산자
		// - (자료형)상수,공간,연산식
		long c = (long)b;
		
		//실수가 하나라도 포함된 연산에서는 실수가 나온다....
		int d = 5;
		int e = 3;
		
		System.out.println((d * e) / 2);
		System.out.println((d * e) / 2.0);
		System.out.println((d * e) / (double)2);
		System.out.println((double)(d * e) / 2);
		
		
		// 실수는 오차때문에 정밀한 계산에서는 사용되지 않는다...
		System.out.println(10 / 3.0);
	}
}






















