package oop.test01;

public class Main {

	
	public static void disp(Info in) {
		System.out.println("이름 : " + in.name);
		System.out.println("나이 : " + in.age);	
	}
	
	public static void main(String[] args) {

		//사람의 정보
		// 이름 , 나이
	
		
		Info in = new Info();

		in.setData("김민준", 20);
		
//		in.name = "김민준";
//		in.age = 20;

		in.disp();
		
		//disp(in);
		
//		System.out.println("이름 : " + in.name);
//		System.out.println("나이 : " + in.age);		
		
		
//		String name = "김민준";
//		int age = 20;
//		
//		System.out.println("이름 : " + name);
//		System.out.println("나이 : " + age);

		
		
	}

}
