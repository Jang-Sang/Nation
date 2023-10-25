package oop.vendingmachine;

public class Menu { //메뉴 관리 클래스.

	private String name;
	private int price;
	
	public Menu(String name,int price) {
		this.name = name;
		this.price = price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void disp(int i) {
		System.out.println("[" + i + "]\t" + name + "\t" + price + "원");
	}
	
//	public void listDisp(Menu[] list) {
//		if(list.length == 0) {
//			System.out.println("메뉴가 없습니다.");
//		}else {
//			for(int i = 0; i < list.length; i++) {
//				list[i].disp(i + 1);
//			}
//		}
//	}
}























