package input;

import java.io.IOException;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) throws IOException {
		
		// System.in - 표준 입력 스트림(객체) - X
		// .read() - buffer안의 데이터를 1byte만큼 읽어오는 메소드
		
		
//		System.out.print("정수 입력 : ");
//		
//		int su = 0;
//		
//		while(true) {
//			int a = System.in.read();
//			
//			
//			if (a == 13) {
//				break;
//			}
//			
//			su *= 10;
//			su += (a - 48);
//
//		}
//		
//		System.out.println("su = " + su);
		
		//Buffer(버퍼)
		// - 데이터의 처리 속도 , 단위 , 시간 등이 서로 다른 두 장치나
		//   프로그램 사이에서 데이터를 주고 받기위한 용도로 사용되는 임시기억장치(메모리)

		// - 키보드 입력시의 버퍼
		//  - 키보드에서 입력된 키값을 버퍼안에 저장한다..
		//  - 공백문자를 기준으로 데이터의 끝을 구분한다..
		
		//System.in을 이용하면 입력받을때 불편하기 때문에....
		//우리는 만들어진 도구를 가져다 사용한다...Scanner
		
		//java.util.Scanner - 데이터를 읽어오기위한 도구
		// - 파일 , Text , URL , InputStream....
		
		Scanner sc = new Scanner(System.in);
	
		// .next()		 - 다음 공백문자까지의 데이터를 읽어오는 메소드 - 한 단어 - String
		// .nextLine()	 - \n을 기준으로 데이터를 읽어오는 메소드 - 한줄	- String
		// .next자료형() - 내가 원하는 데이터형태로 데이터를 읽어오는 메소드
		
		// ※ 메소드명은 첫글자는 대문자 달라지는 단어의 첫글자는 대문자로 작성한다.
		
		System.out.print("나이 입력 : ");
		
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("이름 입력 : ");
		
		String name = sc.nextLine();
		
		System.out.println("이름 : " + name);

		System.out.println("나이 : " + age);
		
//		name = sc.next();
//		
//		System.out.println("이름 : " + name);
	}

}























