package oop.test03;

public class Main {

	
	public static void main(String[] args) {

		
		Info in = new Info();

		System.out.println(in);
		
//		in.name = "김민준";
//		in.age = 20;
		
//		in.setAge(-20);
		
		in.setData("김민준", -20);

		System.out.println(in.getAge());
		
		in.disp();
		
	}

}
