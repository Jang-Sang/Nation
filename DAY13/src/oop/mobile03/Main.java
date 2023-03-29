package oop.mobile03;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
//		(아래의 객체를 생성한 뒤 정보 출력)
//		name		telecom	price	card		month
//		[1]	아이폰7	KT		90만원	국민카드	24개월
//		[2]	갤럭시7	SK		30만원	신한카드	30개월
//		[3]	G6		LG		35만원	삼성카드	36개월
		
		MobileEx m1 = new MobileEx("아이폰", "KT", 900000, "국민카드", 24);
		MobileEx m2 = new MobileEx("갤럭시7", "SKT", 300000, "신한카드", 30);
		MobileEx m3 = new MobileEx("G6", "LGT", 350000, "삼성카드", 36);
		
		m1.disp();
		m2.disp();
		m3.disp();
		
		ArrayList<MobileEx> list = new ArrayList<MobileEx>();
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		//m1.setCard(null);
		
		//list = null;
		
		MobileEx.arrDisp(list);
		
	}
	
}





















