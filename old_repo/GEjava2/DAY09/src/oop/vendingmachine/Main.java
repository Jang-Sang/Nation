package oop.vendingmachine;

import java.util.Scanner;

import oop.student.Student;

public class Main {

	
	//각 클래스별로 구현해서 
	// Main에서 작동하도록 구현하시오.
	
	//메뉴 관리 - 이름,가격
	//1.메뉴 추가 2. 메뉴 삭제 3.가격 수정
	
	//자판기 - 메뉴리스트, 투입금액 , 총 판매금액
	//1.메뉴 선택
	//2.반환
	//3. 총 판매금액
	//4. 종료

	public static void main(String[] args) {
		
		new Controller();
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		VendingMachine vm = new VendingMachine();
//		
//		boolean check = false;
//		int price = 0;
//		String name = null;
//		int su = 0;
//		int select = 0;
//		
//		vm.addMenu(new Menu("커피", 200));
//		vm.addMenu(new Menu("율무차", 250));
//		vm.addMenu(new Menu("코코아", 250));
//		
//		while(true) {
//			System.out.print("1. 메뉴 관리 2. 자판기 관리 3.종료\n입력 : ");
//			select = sc.nextInt();
//			boolean flag = true;
//			
//			switch(select) {
//			case 1:
//				while(flag) {
//					System.out.print("1.메뉴입력 2.메뉴삭제 3.메뉴수정 4.메뉴출력 5.이전메뉴\n입력 : ");
//					select = sc.nextInt();
//					
//					switch(select) {
//					case 1:
//						System.out.print("이름 입력 : ");
//						name = sc.next();
//						while(true) {
//							System.out.print("가격 입력 : ");
//							price = sc.nextInt();
//							if(price < 0) {
//								System.out.println("가격이 잘못 입력 하였습니다.");
//							}else {
//								break;
//							}
//						}
//						check = vm.addMenu(new Menu(name, price));
//						if(check) {
//							System.out.println("입력 성공!");
//						}else {
//							System.out.println("입력 실패!");
//						}
//						break;
//					case 2:
//						vm.listDisp();
//						System.out.print("삭제할 메뉴 번호 입력 : ");
//						su = sc.nextInt();
//						if(su < 1 || su > vm.getSu()) {
//							System.out.println("잘못된 번호 입력!");
//							break;
//						}
//						check = vm.removeMenu(su);
//						if(check) {
//							System.out.println("삭제 성공!");
//						}else {
//							System.out.println("삭제 실패!");
//						}
//						break;
//					case 3:
//						vm.listDisp();
//						System.out.print("수정할 메뉴 번호 입력 : ");
//						su = sc.nextInt();
//						if(vm.getSu() == 0) {
//							break;
//						}
//						if(su < 1 || su > vm.getSu()) {
//							System.out.println("잘못된 번호 입력!");
//							break;
//						}
//						while(true) {
//							System.out.print("가격 입력 : ");
//							price = sc.nextInt();
//							if(price < 0) {
//								System.out.println("가격이 잘못 입력 하였습니다.");
//							}else {
//								break;
//							}
//						}
//						vm.updateMenu(su,price);
//						System.out.println("수정 성공!");
//						break;
//					case 4:
//						vm.listDisp();
//						break;
//					case 5:
//						flag = false;
//						break;
//					default:
//						System.out.println("잘못된 선택!");
//					}
//				}
//				break;
//			case 2:
//				System.out.print("금액 투입 : ");
//				int amount = sc.nextInt();
//				if(amount < 1) {
//					System.out.println("잘못된 금액 투입!이전 메뉴로...");
//					break;
//				}else {
//					vm.setAmount(amount);
//				}
//				
//				while(flag) {
//					System.out.println("1. 메뉴 선택     \r\n" + 
//							"2. 반환        \r\n" + 
//							"3. 총 판매금액   \r\n" + 
//							"4. 이전메뉴       \r\n" + 
//							"입력 : ");
//					select = sc.nextInt();
//					
//					switch(select) {
//					case 1:
//						vm.listDisp();
//						System.out.print("메뉴 번호 입력 : ");
//						su = sc.nextInt();
//						if(su < 1 || su > vm.getSu()) {
//							System.out.println("잘못된 번호 입력!");
//							break;
//						}
//						vm.outputMenu(su);
//						break;
//					case 2:
//						System.out.println(vm.getAmount() + "원이 반환 됩니다.");
//						vm.setAmount(0);
//						break;
//					case 3:
//						System.out.println("총 판매 금액 : " + vm.getTotal());
//						break;
//					case 4:
//						flag = false;
//						break;
//					default:
//						System.out.println("잘못된 선택!");
//					}
//				}
//				break;
//			case 3:
//				System.out.println("프로그램이 종료됩니다.");
//				sc.close();
//				System.exit(0);//프로그램 종료 메소드
//				// 0은 정상 종료 
//				// 0이 아닌수 - 비정상종료
//			default:
//				System.out.println("잘못된 선택!");
//			}
//		}
		
		
	}
	
	
}


















