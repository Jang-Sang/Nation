package oop.vendingmachine;

import java.util.Scanner;

//프로그램을 관리하는 클래스
public class Controller {

	private Scanner sc = new Scanner(System.in);
	private VendingMachine vm = new VendingMachine();
	
	
	public Controller() {
		vm.addMenu(new Menu("커피", 200));
		vm.addMenu(new Menu("율무차", 250));
		vm.addMenu(new Menu("코코아", 250));
		menu();
	}
	
	private void menu() {
		while(true) {
			System.out.print("1. 메뉴 관리 2. 자판기 관리 3.종료\n입력 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				menuManage();
				break;
			case 2:
				VMManage();
				break;
			case 3:
				System.out.println("프로그램이 종료됩니다.");
				sc.close();
				System.exit(0);//프로그램 종료 메소드
				// 0은 정상 종료 
				// 0이 아닌수 - 비정상종료
			default:
				System.out.println("잘못된 선택!");
			}
		}
		
	}
	
	private void VMManage() {
		System.out.print("금액 투입 : ");
		int amount = sc.nextInt();
		if(amount < 1) {
			System.out.println("잘못된 금액 투입!이전 메뉴로...");
			return;
		}else {
			vm.setAmount(amount);
		}
		
		while(true) {
			System.out.print("1. 메뉴 선택     \r\n" + 
					"2. 반환        \r\n" + 
					"3. 총 판매금액   \r\n" + 
					"4. 이전메뉴       \r\n" + 
					"입력 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				selectMenu();
				break;
			case 2:
				returnMoney();
				break;
			case 3:
				totalMoney();
				break;
			case 4:
				return;
			default:
				System.out.println("잘못된 선택!");
			}
		}
		
	}

	private void totalMoney() {
		System.out.println("총 판매 금액 : " + vm.getTotal());
	}

	private void returnMoney() {
		System.out.println(vm.getAmount() + "원이 반환 됩니다.");
		vm.setAmount(0);
	}

	private void selectMenu() {
		vm.listDisp();
		int su = numInput("");
		vm.outputMenu(su);
	}

	private int priceInput() {
		while(true) {
			System.out.print("가격 입력 : ");
			int price = sc.nextInt();
			if(price < 0) {
				System.out.println("가격이 잘못 입력 하였습니다.");
			}else {
				return price;
			}
		}
	}
	
	private int numInput(String msg) {
		System.out.print(msg + " 메뉴 번호 입력 : ");
		int su = 0;
		while(true) {
			su = sc.nextInt();
			if(su < 1 || su > vm.getSu()) {
				System.out.println("잘못된 번호 입력!");
			}else {
				return su;
			}
		}
	}
	
	private void menuManage() {
		while(true) {
			System.out.print("1.메뉴입력 2.메뉴삭제 3.메뉴수정 4.메뉴출력 5.이전메뉴\n입력 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				menuInput();
				break;
			case 2:
				menuRemove();
				break;
			case 3:
				menuUpdate();
				break;
			case 4:
				vm.listDisp();
				break;
			case 5:
				return;
			default:
				System.out.println("잘못된 선택!");
			}
		}
	}
	
	private void menuUpdate() {
		vm.listDisp();
		int su = numInput("수정할");
		int price = priceInput();
		vm.updateMenu(su,price);
		System.out.println("수정 성공!");
	}
	
	private void menuRemove() {
		vm.listDisp();
		int su = numInput("삭제할");
		boolean check = vm.removeMenu(su);
		if(check) {
			System.out.println("삭제 성공!");
		}else {
			System.out.println("삭제 실패!");
		}
		
	}

	private void menuInput() {
		System.out.print("이름 입력 : ");
		String name = sc.next();
		int price = 0;
		while(true) {
			System.out.print("가격 입력 : ");
			price = sc.nextInt();
			if(price < 0) {
				System.out.println("가격이 잘못 입력 하였습니다.");
			}else {
				break;
			}
		}
		boolean check = vm.addMenu(new Menu(name, price));
		if(check) {
			System.out.println("입력 성공!");
		}else {
			System.out.println("입력 실패!");
		}
	}
	
}
