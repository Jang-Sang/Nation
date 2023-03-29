package oop.poly01;

public class Animal {
	
	private String name; //동물 이름
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void bark() {
		//울음소리
		System.out.println("???????????????");
	}
	
	public void disp() {
		System.out.println("이름 : " + name);
	}
}
