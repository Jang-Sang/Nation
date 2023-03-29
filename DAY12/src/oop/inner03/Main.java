package oop.inner03;

public class Main {

	public static void main(String[] args) {
		
		//익명중첩클래스
		// - 객체 상황에 맞게 클래스를 재정의 하는 구문...
		// - 현재 사용할 객체 상황상 맞지 않는 부분을 수정하거나
		//   필요한 내용을 추가하는 구문...
		// - 추상클래스와 인터페이스들을 객체 생성할때 사용하기도 한다.
		
		
		// - 오버라이드
		//  - 메소드의 재정의
		//  - 메소드의 형태는 같게 하고 내용을 재정의 하는 구문...
		
		Key enter = new Key() {
			public void push() {
				System.out.println("실행");
			}
		};
		
		enter.push();
		
		Key esc = new Key() {
			public void push() {
				exit();
				System.out.println("종료!");
			}
			
			public void exit() {
				System.out.println("프로그램 종료!");
				System.exit(0);
			}
		};
		
		//esc.exit();
		esc.push();
		
		
	}
	
}

















