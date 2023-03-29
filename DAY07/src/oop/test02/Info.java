package oop.test02;

//class Info2 {
//	
//}


public class Info {
	private String name;
	private int age;

	
	//메소드
	public void setData(String _name,int _age) {
		name = _name;
		age = _age;
	}

	public void disp() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);	
	}
}
