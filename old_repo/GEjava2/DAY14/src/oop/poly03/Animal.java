package oop.poly03;

//추상클래스
// - 부모의 역할을 수행하기위해서 만들어지는 클래스...
// - 다형성을 위해서 만들어 진다...
// - abstract키워드를 붙여서 만든 클래스.
//  - 추상 메소드를 하나라도 포함하고 있는 클래스
// - 기본적으로 객체 생성 불가...익명중첩클래스를 통하여 객체 생성 가능...
// - 상속을 통해 추상 메소드를 오버라이드 해주어야 한다...

public abstract class Animal {
	
	private String name; //동물 이름
	
	public Animal(String name) {
		this.name = name;
	}
	
	
	//추상메소드
	// - 빈껍데기 메소드
	// - abstract 를 붙여서 만든 메소드
	// - 코드 정의부가 없다...
	// - 반드시 오버라이드가 되어야 사용가능하다...
	public abstract void bark();
	
	public void disp() {
		System.out.println("이름 : " + name);
	}
}
