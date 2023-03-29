package oop.phonebook;

//예외처리 try~catch.....
// + @ 그룹추가 - Map<그룹,ArrayList<PhoneBook>>

public class Main {
	//PhoneNumber - 전화번호 관리 클래스 - 집 : 052-260-6038...
	//PhoneBook - 전화번호부 - 이름 , PhoneNumber 3개 까지만 관리
	//Controller - 컨트롤 클래스 - 프로그램 전반적인 관리
	//입력 , 수정 , 삭제 , 검색(전체 , 하나)
	//Main - 프로그램 실행 클래스

	public static void main(String[] args) {
		
		
		new Controller();
	}
}

