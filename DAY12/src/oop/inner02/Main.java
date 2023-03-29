package oop.inner02;

public class Main {

	public static void main(String[] args) {
		//지역중첩클래스...
		// - 메소드 안에서 사용되는 클래스...
		// - 임시적인 데이터 관리를 위해서 만들어진다...
		// - 데이터관리할때 사용한다...
		//   - 보통 getter와 setter는 안만든다...
		//   - 생성자도 안만든다...
		//   - 멤버변수만 만들어서 묶어서 관ㄹㅣ한다....
		
		class Info{
			String name;
			int age;
		}
		
		Info in = new Info();
		
		in.name = "김민준";
		in.age = 20;
		
		
	}

}
