package oop.mobile03;

import java.util.ArrayList;

public class MobileEx extends Mobile{
//	기존에 Mobile이라는 클래스를 사용하여 휴대전화 정보를 
//	관리하였습니다. 
//	세월이 지나서 항목들이 추가가 되었습니다.
//	Mobile이라는 클래스는 건드리지 않고 상속을 이용하여 추가된 
//	항목까지 저장하게 만들고 싶습니다.	
//	이름은 MobileEx로 생성
//	(추가된 항목)	제휴카드(card)	수시로 설정 / 확인 가능
//			약정기간(month)	휴대폰 약정기간(월)
	private String card;
	private final int month;
	
	public MobileEx(String name,String tel,int price,String card,int month) {
		super(name, tel, price);
		this.card = card;
		this.month = month;
	}
	
	public void setCard(String card) {
		this.card = card;
	}
	
	public String getCard() {
		return card;
	}
	public int getMonth() {
		return month;
	}
	
	public void disp() {
		super.disp();
		System.out.println("제휴카드 : " + card);
		System.out.println("약정기간 : " + month + "개월");
	}
	
	public void disp(int i) {
		System.out.println("[" + i + "]\t" + getName() + "\t" + getTel() + "\t" + getPrice() + "원\t" + card + "\t" + month + "개월");
	}


	public static void arrDisp(ArrayList<MobileEx> list) {
		if(list == null) {
			System.out.println("제대로 된 데이터를 넣으십시오...");
			return;
		}
		
		System.out.println("\tname\ttel\tprice\t\tcard\t\tmonth");
		if(list.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		}else {
			int i = 1;
			for(MobileEx m : list) {
				m.disp(i);
				i++;
			}
		}
	}
	
//	(아래의 객체를 생성한 뒤 정보 출력)
//	name		telecom	price	card		month
//	[1]	아이폰7	KT		90만원	국민카드	24개월
//	[2]	갤럭시7	SK		30만원	신한카드	30개월
//	[3]	G6		LG		35만원	삼성카드	36개월
}













