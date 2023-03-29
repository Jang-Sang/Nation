package oop.static01;

//static 멤버
// - static 을 붙여서 선언된 멤버
// - 객체 생성과 상관 없이 사용되는 멤버
// - 클래스명을 통해서 접근 하면 된다...
// - 접근 지정자의 영향을 받는다.

public class Test {

	private int no; // 객체 번호
	private static int su = 10; // 총 객체 수
	//static 멤버변수
	// - 모든 객체가 일괄적으로 처리되어야 할 데이터를 저장하는 멤버변수 공간
	// - 모든 객체를 통틀어서 단 하나의 공간만 만들어진다.,..
	// - 모든 객체가 하나의 공간을 참조하게 된다...Static영역
	// - 프로그램이 실행할때 공간이 만들어지고 프로그램이 끝날때 공간이 소멸된다...
	//  - 객체 생성 이전에 먼저 만들어져 있는 공간.
	
	
	//static 멤버 메소드
	// - 클래스의 기능과는 연관이 있지만 객체 생성과는 상관 없는 기능을 만들때 사용하는 멤버 메소드
	// - this를 사용할수 없다.
	// - static멤버만 사용 가능하다.
	
	public static void setSu(int su) {
		Test.su = su;
		//this.su = su;
		//no = 50;
//		Test t = new Test(1, 1);
//		t.no = 20;

		//disp();
	}
	
	
	public Test(int no,int su) {
		System.out.println(Test.su);
		this.no = no;
		Test.su = su;// 권장방식
		//this.su = su; //비권장방식
	}
	
	public void disp() {
		System.out.println("객체 번호 : " + no + "\t 총 객체 수 : " + su);
	}
	
}


