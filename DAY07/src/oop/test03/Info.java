package oop.test03;

public class Info {
	private String name;
	private int age;

	//this
	// - 멤버 메소드에서 자동으로 만들어지는 0번째 매개변수
	// - 자기자신을 호출한 객체의 인스턴스공간의 정보를 저장하는 참조형 변수
	// - 멤버 메소드 내부에서만 사용이 가능하다....
	// - 당분간은....멤버부를때 붙이자....
	
	//getter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(/*Info this*/int age) {
		if(age < 1) {
			System.out.println("잘못된 나이 입력!!!");
			this.age = 1;
			return;
		}
		//System.out.println(this);
		this.age = age;
	}
	
	//메소드
	public void setData(String name,int age) {
		this.name = name;
		this.setAge(age);
//		if(age < 1) {
//			System.out.println("잘못된 나이 입력!!!");
//			this.age = 1;
//			return;
//		}
//		this.age = age;
	}

	public void disp() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);	
	}
}
