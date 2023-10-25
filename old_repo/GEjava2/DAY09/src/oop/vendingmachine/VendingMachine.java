package oop.vendingmachine;

public class VendingMachine { //자판기 관리 클래스.
	private Menu[] list = new Menu[10];
	private int su; // 메뉴수
	private int total;
	private int amount;
	
	public boolean addMenu(Menu m) {
		if(su == list.length) {
			return false;
		}
		list[su] = m;
		su++;
		return true;
	}
	
	public int getSu() {
		return su;
	}
	public int getTotal() {
		return total;
	}
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void updateMenu(int idx,int price) {
		list[idx-1].setPrice(price);
	}
	
	public boolean removeMenu(int idx) {
		if(su == 0) {
			return false;
		}
		list[idx - 1] = null;
		for(int i = idx-1; i < su; i++ ) {
			list[i] = list[i + 1];
		}
		list[--su] = null;
		return true;
	}
	
	public void listDisp() {
		if(su == 0) {
			System.out.println("메뉴가 없습니다.");
		}else {
			for(int i = 0; i < su; i++) {
				list[i].disp(i + 1);
			}
		}
	}

	public void outputMenu(int su) {
		Menu m = list[su - 1];		
		if(m.getPrice() > amount) {
			System.out.println("잔액이 부족합니다.");
		}else {
			System.out.println(m.getName() + "가 나왔습니다.");
			this.amount -= m.getPrice();
			this.total += m.getPrice();
		}
	}
}






















