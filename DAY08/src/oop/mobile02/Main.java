package oop.mobile02;

public class Main {

	public static void main(String[] args) {
		
//		(객체 생성 후 아래의 내용을 구현)
//		name		telecom		price
//	[1]	갤럭시8		SKT			300000
//	[2] 	G6		LG			330000
//	[3]	아이폰7		KT			510000
//	아이폰과 갤럭시8의 가격을 비교하여 비싼 휴대폰 이름을 출력
		Mobile m1 = new Mobile("갤럭시8", "SKT", 300000);
		Mobile m2 = new Mobile("G6", "LGT", 330000);
		Mobile m3 = new Mobile("아이폰7", "KT", 510000);
		
		m1.disp();
		m2.disp();
		m3.disp();
		
		m1.compare(m3);
		
		m2.compare(m1);
		
//		if(m1.getPrice() < m3.getPrice()) {
//			System.out.println(m3.getName());
//		}else if(m1.getPrice() > m3.getPrice()) {
//			System.out.println(m1.getName());
//		}else {
//			System.out.println("같다");
//		}
		
		Mobile[] arr = new Mobile[5];
		
		Mobile.arrDisp(arr);
		
		//arr[0].arrDisp(arr);
		
//		System.out.println("\tname\ttel\tprice");
//		for(int i = 0; i < arr.length; i++) {
//			arr[i].disp(i + 1);
//		}
	}
	
}





















