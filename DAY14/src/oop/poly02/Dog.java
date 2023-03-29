package oop.poly02;

public class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}
	
	public void bark() {
		System.out.println("멍멍");
	}
	
	public void eat() {
		System.out.println("뼈다귀");
	}

}
