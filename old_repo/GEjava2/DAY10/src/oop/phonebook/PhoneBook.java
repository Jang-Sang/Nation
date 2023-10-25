package oop.phonebook;

import java.util.ArrayList;

//PhoneBook - 전화번호부 - 이름 , PhoneNumber 3개 까지만 관리
public class PhoneBook {
	private String name;
	private ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>();
	
	public PhoneBook() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	//입력 수정(전화번호 추가,수정,삭제) 삭제 검색
	
	//입력
	public boolean addPhoneNumber(PhoneNumber pn) {
		if(list.size() >= 3) {
			System.out.println("전화번호를 더 추가할수 없습니다.");
			return false;
		}
		list.add(pn);
		return true;
	}
	
	//폰 번호 출력
	public void numberDisp() {
		if(list.isEmpty()) {
			System.out.println("전화번호가 없습니다.");
		}else {
			for(int i = 0; i < list.size(); i++) {
				System.out.print("[" + (i + 1) + "]");
				list.get(i).disp();
			}
		}
	}
	
	//전화번호 갯수반환
	public int getNumberEA() {
		return list.size();
	}
	
	//전체출력
	public void disp(int i) {
		System.out.print(String.format("%-10s", String.format("%2d. %4s ", i, name)));
		if(list.isEmpty()) {
			System.out.println("전화번호가 없습니다.");
		}else {
			for(i = 0; i < list.size(); i++) {
				if(i != 0) {
					System.out.print(String.format("%10s", ""));
				}
				list.get(i).disp();
			}
		}
	}
	
	public boolean numberFind(String number) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).numberContains(number)) {
				return true;
			}
		}
		return false;
	}
	
	public void kindDisp(int i,String kind) {
		System.out.print(String.format("%-10s", String.format("%2d. %4s ", i, name)));
		if(list.isEmpty()) {
			System.out.println("전화번호가 없습니다.");
		}else {
			boolean check = true;
			for(i = 0; i < list.size(); i++) {
				if(i != 0 && !check) {
					System.out.print(String.format("%10s", ""));
				}
				if(list.get(i).kindContians(kind)) {
					list.get(i).disp();
					check = false;
				}
			}
			if(check) {
				System.out.println("전화번호가 없습니다.");
			}else {
				System.out.println();
			}
		}
	}

	public void updateNumber(int i, PhoneNumber pn) {
		this.list.set(i, pn);
	}

	public void deleteNumber(int i) {
		this.list.remove(i);
	}
	
	
}




















