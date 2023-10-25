package oop.poly04;

//CPP에서는 다중상속의 문제점이 있었다...
//CPP에서는 권장하지 않는 문법이다...

// JAVA에서는 CPP에서의 다중상속 문제점을 보완 하였다... - interface
// interface를 통하여 다중상속을 한다...
// - implements 키워드를 통하여 다중상속을 받는다...



public class Cat extends Animal/* ,Bark */ implements Bark,Eat{

	public Cat(String name) {
		super(name);
	}
	
	public void bark() {
		System.out.println("야옹");
	}
	
	public void eat() {
		System.out.println("생선");
	}
	
	public void info() {
		System.out.println("고양이 info");
	}

}
