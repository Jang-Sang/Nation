package oop.mobile01;

public class Main {

	public static void main(String[] args) {
		
		
		String classPath = "oop.mobile01.Mobile";
		
		Mobile m = null;
		try {
			m = (Mobile) Class.forName(classPath).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(m instanceof Mobile);
		
		
		
//		클래스를 만들고 아래의 객체를 생성한 뒤 정보를 화면에 출력
//		name		telecom		price
//	[1]	G6			LG			70만원
//	[2]	아이폰7		KT			95만원
//	[3]	S8			SKT			90만원
		
		Mobile m1 = new Mobile("G6", "LGT", 70);
		Mobile m2 = new Mobile("아이폰7", "KT", 95);
		Mobile m3 = new Mobile("S8", "SKT", 90);
		
		
		m1.disp(1);
		m2.disp(2);
		m3.disp(3);
		
		Mobile[] arr = new Mobile[] {new Mobile("G6", "LGT", 70),m2,m3};
		
//		System.out.println(m1);
//		System.out.println(arr[0]);
//		
//		m1.setName("바뀐다");
		
		System.out.println("\tname\ttel\tprice");
		for(int i = 0; i < arr.length; i++) {
			arr[i].disp(i + 1);
		}
		
	}
	
}
