package oop.poly04;

//interface
// - 다중상속 전용 클래스
// - 클래스의 변형...빈껍데기 클래스
// - 구성이 제한적이다...
// - 확실하면 적고 확실하지 않으면 적지마라
// - extends - 인터페이스 상속...여러개가 가능하다...

public interface Bark /* extends Disp,Eat */{
	
	//멤버변수 - 상수화변수만 가능하다....
	/*public static final*/String SKILL1 = "q";
	
	//멤버 메소드
	// 1. 추상메소드
	/* public abstract */void bark();
	// 2. static 메소드
	static void disp() {
		System.out.println("Bark");
	}
	// 3. default 메소드 - interface에서만 정의 가능한 메소드...
	// - 유지,보수에 용이 하도록 만들어 졌다..
	public default void info() {
		System.out.println("info");
	}
}
