package oop.poly02;

import java.util.Random;

public class Main {
	
	public static void bark(Animal a) {
		a.bark();
	}
	
	public static void eat(Dog d) {
		d.eat();
	}
	
	public static void eat(Cat c) {
		c.eat();
	}
	
	public static void main(String[] args) {

		int su = new Random().nextInt(2); // (int)(Math.random() * 2);
		
		Animal a = null;
		
		if(su == 0) {
			a = new Dog("강아지");
		}else {
			a = new Cat("고양이");
		}
		
		a.bark();
		
		
//		if(su == 0) {
//			Dog d = new Dog("강아지");
//			d.eat();
//		}else {
//			Cat c = new Cat("고양이");
//			c.eat();
//		}
	}
	
}


























