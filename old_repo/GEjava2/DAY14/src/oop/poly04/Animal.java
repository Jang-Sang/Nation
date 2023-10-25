package oop.poly04;

public abstract class Animal {
	
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public abstract void bark();
	
	public void disp() {
		System.out.println("이름 : " + name);
	}
}
