package oop.final01;

public class Test01 {

	public static void main(String[] args) {
		
		//지정자(제한자)
		// - 어떠한 설정을 지정할수 있는 키워드
		// - 어떠한 제한을 설정하는 키워드...
		
		// final - 마지막...
		// - 변수 - 마지막 설정값...
		// - 메소드 - 오버라이드(메소드의 재정의) 금지
		// - 클래스 - 상속 금지
		
		//final int a = 10; // 설정
		
		//a = 20; // 재설정 X
		
		final int a;
		
		a = 10; // 설정
		
		//a = 20; // 재설정 X
		
		//final 멤버변수
		// - final 키워드를 붙여서 만든 멤버변수..
		// - 반드시 생성자 안에서 멤버변수를 초기화 해주어야 한다...
	}
	
}
