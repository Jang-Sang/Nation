package oop.overload;

public class Main {
	
	//CPP - 오버로드 , 디폴트매개변수
	// Python - 디폴트매개변수
	// JAVA - 오버로드
	
	//C언어에서의 함수 호출 방식
	// - 함수를 참조할때 함수명만 가지고 함수를 참조한다...
	// - 함수명의 중복 정의 불가...
	
	//CPP에서의 함수 호출 방식
	// - 함수를 참조할때 함수명과 자료형을 가지고 함수를 참조한다...
	// - 함수명의 중복 정의 가능....함수의 오버로드
	
	//메소드의 오버로드
	// - 메소드명의 중복 정의
	// - 같은 기능의 메소드들을 하나의 이름으로통합적으로 사용하되 
	//   매개변수의 자료형으로 구분하여 여러개의 메소드를 만들어 놓기 위해서....
	
	// 오버로드의 조건
	// - 반환자료형은 오버로드 조건에 해당되지 않는다....
	// - 매개변수의 자료형 , 개수 , 순서  셋중에 하나라도 다르면 오버로드 조건에 해당된다....
	
	void disp() {
		System.out.println("a = 10");
	}
	
//	int disp() {
//		System.out.println("a = 10");
//		return 5;
//	}
	
	void disp(int a) {
		System.out.println("a = " + a);
	}
	void disp(int a,double b) {
		System.out.println("a = " + a);
	}
	void disp(double a,int b) {
		System.out.println("a = " + a);
	}
	void disp(double a) {
		System.out.println("a = " + a);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println();
	}

}

















