package variable;

import java.lang.*;

public class Test04 {

	public static void main(String[] args) {
		
		//논리형 - boolean - 1byte
		// - 참과 거짓을 저장하고 관리하는 자료형
		// - 참(true) / 거짓(false)
		
		boolean a = true;//false
		
		System.out.println(a);
		
		// 관계 연산자 - 데이터
		// >  <  >=  <=  == !=
		System.out.println(10 == 5);
		
		a = 10 > 5;
		System.out.println(a);
		
		
		//논리연산자 - 조건식
		// - 참과 거짓을 판별하는 연산자...
		
		// &&	논리곱(and)		양쪽 모두 참이면 참을 발생....
		// ||	논리합(or)		한쪽이라도 참이면 참을 발생....
		// !	부정(not)		참이면 거짓 , 거짓이면 참....
		
		//							or			and
		//	true		true		true		true
		//	false		true		true		false
		//	true		false		true		false
		//	false		false		false		false
		
		System.out.println("======================================================");
		
		System.out.println(10 > 0 || 10 < 50);
		System.out.println(10 < 0 || 10 < 50);
		System.out.println(10 > 0 || 10 > 50);
		System.out.println(10 < 0 || 10 > 50);
		
		System.out.println("======================================================");
		
		System.out.println(10 > 0 && 10 < 50);
		System.out.println(10 < 0 && 10 < 50);
		System.out.println(10 > 0 && 10 > 50);
		System.out.println(10 < 0 && 10 > 50);
		
		System.out.println("==========================================");
		
		System.out.println(!(10 > 5));
		System.out.println(!(10 < 5));
	}
	
}
