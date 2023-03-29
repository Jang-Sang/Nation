package oop.poly04;

public class Main {
	
	public static void disp(Animal a) {
		a.disp();
	}
	
	public static void bark(Bark b) {
		b.bark();
	}
	
	public static void eat(Eat e) {
		e.eat();
	}
	
	
	public static void main(String[] args) {
		
	
		Cat c = new Cat("고양이");
		Dog d = new Dog("강아지");
		
		
		disp(c);
		disp(d);
		
		eat(c);
		eat(d);
		
		c.disp();
		
		Bark.disp();
		c.info();
		
	}
	
}


























