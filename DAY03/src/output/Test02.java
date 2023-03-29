package output;

public class Test02 {

	public static void main(String[] args) {
		
		//제어문자
		// -문자열에서 특수한 기능을 하는 문자
		// - 약 30가지....
		// - 대부분 출력과 연관이 있다...
		// - 문자열에서 실행하고자 하는 위치에 \를 적고 기능에 맞는 문자를 적어주면된다.
		
		
		// \n(New Line , Line Feed) - 10
		// - 커서를 다음줄로 이동시키는 제어문자
		System.out.println("a\nb");
		
		System.out.println((int)'\n');
		
		// \t(Horizontal Tab) - TAB - 9
		// - 커서를 TAB크기만큼 이동시키는 제어문자..
		// - 일반적으로 영문자기준 8글자 한글기준 4글자.,..
		System.out.println("이름\t : 김민준");
		System.out.println("전화번호 : 010-3666-6768");
		
		// \r (Carroage Return) - 13 - Enter
		// - 커서를 줄의 처음으로 이동시키는 제어문자
		// \b (Back Space) - 8
		// - 커서를 왼쪽으로 한칸 이동시키는 제어문자
		
		
		System.out.println("ABCDE\rabc");
		
		System.out.println("ABCDEF\babc");
		
		//문자열에서 특수한 기능을 하는 문자들..
		// - \뒤에 적으면 문자로 인식된다...
		
		// "" - 문자열 데이터를 구별하기위한 기호
		
		// "HI"
		System.out.println("\"HI\"");
		System.out.println("'HI'");
		System.out.println("\"HI\"");
		
		// \ - 제어문자를 사용하기위한 기호
	
		// G:\디지털데이터 융합 자바기반 풀스택개발자A 2\JAVA\workspace
		System.out.println("G:\\디지털데이터 융합 자바기반 풀스택개발자A 2\\JAVA\\workspace");
		System.out.println("G:\\디지털데이터 융합 자바기반 풀스택개발자A 2\\JAVA\\workspace");
		
	}

}






















