package oop.poly01;

public class Main {
	
	public static void main(String[] args) {

		//타입일치형
//		Dog d = new Dog("강아지");
//		
//		d.disp();
//		d.bark();
//		d.eat();
		
		//Animal a = new Animal("동물");
		
		//타입불일치
		//업캐스팅 - 자식 -> 부모
		// - 자식인스턴스 공간을 부모의 참조형변수에 저장하는 형태...
		Animal a = new Dog("강아지");
		a.disp(); //부모클래스의 고유한 기능은 사용 가능
		a.bark(); //오버라이드 메소드는 자식클래스의 메소드를 사용한다...
		//a.eat(); //자식클래스의 고유한 기능 사용 불가
		
		//다운캐스팅 -> 부모 -> 자식 - jsp.......
		// - 타입불일치에서 타입일치....
		Dog d = (Dog)a;
	}
	
}
