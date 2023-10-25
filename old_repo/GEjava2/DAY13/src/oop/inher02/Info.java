package oop.inher02;

public class Info {
	private String name;
	private int age;

	//디폴트 생성자
	public Info() {
		System.out.println("부모 디폴트 생성자 호출");
	}
	
	//생성자
	public Info(String name) {
		this.name = name;
	}

	public Info(int age) {
		this.setAge(age);
	}
	
	
	public Info(String name,int age) {
		System.out.println("부모 생성자 호출");
		this.name = name;
		this.setAge(age);
	}
	
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
	
	public void setAge(int age) {
		if(age < 1) {
			System.out.println("잘못된 나이 입력!!!");
			this.age = 1;
			return;
		}
		this.age = age;
	}
	
	//메소드
	public void setData(String name,int age) {
		this.name = name;
		this.setAge(age);
	}

	public void disp() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);	
	}
}






















