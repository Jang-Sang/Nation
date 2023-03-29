package oop.mobile01;

public class Mobile {

	
//	[문제] oop.mobile01 패키지를 만들고 문제를 푸세요
//
//	Main.java	main() 메소드를 가지는 클래스
//	Mobile		휴대전화 클래스
//		(항목) 이름, 통신사, 가격
//		(메소드) disp(출력)
//		(생성자) 알아서~
	private String name;
	private String tel;
	private int price;
	
	public Mobile() {
		
	}
	
	public Mobile(String name) {
		this.name = name;
	}
	
	public Mobile(String name,String tel,int price) {
		this.name = name;
		this.tel = tel;
		this.price = price;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//getter
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public int getPrice() {
		return price;
	}
	
	public void disp() {
		System.out.println("모델명 : " + name);
		System.out.println("통신사 : " + tel);
		System.out.println("가격 : " + price + "만원");
	}
	
	public void disp(int i) {
		System.out.println("[" + i + "]\t" + name + "\t" + tel + "\t" + price + "만원");
	}
	
}



















