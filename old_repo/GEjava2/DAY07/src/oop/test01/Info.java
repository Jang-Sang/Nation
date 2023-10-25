package oop.test01;

public class Info {
	String name;
	int age;

	
	//메소드
	
	void setData(String _name,int _age) {
		name = _name;
		age = _age;
	}

	void disp() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);	
	}
}
