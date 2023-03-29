package oop.poly03;

public class Cat extends Animal{

	public Cat(String name) {
		super(name);
	}
	
	public void bark() {
		System.out.println("야옹");
	}
	
	public void eat() {
		System.out.println("생선");
	}

}
