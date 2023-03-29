package oop.static01;

public class Main {

	public static void main(String[] args) {
		
//		System.currentTimeMillis();
//		Thread.sleep(millis);
//		Math.random();
//		System.exit(status);
		
		//System.out.println(Test.su);
		
		Test.setSu(20);
		
		//System.out.println(Test.su);
		
		Test t1 = new Test(1,1);
		Test t2 = new Test(2,2);
		Test t3 = new Test(3,3);
		
		
		//t1.setSu(su);
		
		t1.disp();
		t2.disp();
		t3.disp();
	}

}
