package oop.inner01;

public class Main {

	public static void main(String[] args) {
		
		//중첩클래스
		// - 클래스 안에 만들어지는 클래스...
		
		// 1. 일반 중첩클래스
		// 2. static 중첩클래스
		// 3. 지역중첩클래스
		// 4. 익명중첩클래스		**************************
		
		// 1. 일반 중첩클래스
		// 2. static 중첩클래스
		// - 클래스 안에 만들어지는 멤버클래스
		// - 클래스에서는 필요하지만 외부에서 단독적으로 쓰임이 없는 것을 관리하기 위해서 만든다...
		
		
		Suit s = new Suit();
		
		//s.price = s.t.price + s.b.price;
		
		Suit.Top t = new Suit.Top();
		//Suit.Bottom b = s.new Bottom();
	}
	
}




























