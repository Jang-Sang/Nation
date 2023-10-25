package oop.inher02;

public class NewInfo extends Info {

	private double height;
	
	//자식클래스에서 별다른 명시가 없으면 부모의 디폴트 생성자를
	// 호출한다....
	//명시를 통해서 부모의 생성자를 선택적으로 호출할수 있다...
	//부모의 멤버변수를 초기화 하려면 자식생성자에서
	//부모의 멤버변수값까지 함께 받아주어야 한다..
	
	//super - 부모의 인스턴스공간을 참조하는 참조형 변수
	//나머지는 this와 같다..
	
	//this - 자기 자신  super - 부모
	
	public NewInfo() {
		super();
		System.out.println("자식 디폴트 생성자 호출!");
	}
	
	public NewInfo(String name,int age,double height) {
		super(name,age);
		//System.out.println(super.getClass());
//		this.name = name; //부모의 private 멤버는 접근 불가..
//		this.setName(name);
//		this.setAge(age);
		System.out.println("자식 생성자 호출!");
		this.height = height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void disp() {
		super.disp();
//		System.out.println("이름 : " + getName());
//		System.out.println("나이 : " + getAge());
		System.out.println("키 : " + height);
	}
}






















