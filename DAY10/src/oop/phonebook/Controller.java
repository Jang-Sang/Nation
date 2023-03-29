package oop.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//Controller - 컨트롤 클래스 - 프로그램 전반적인 관리
public class Controller {
	private Scanner sc = new Scanner(System.in);
	//private ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
	private Map<String, ArrayList<PhoneBook>> list = new HashMap<String, ArrayList<PhoneBook>>();
	
	
	public Controller() {
		menu();
	}

	private void menu() {
		while(true) {
			//입력 수정(전화번호 추가,수정,삭제) 삭제 검색
			System.out.println("전화번호부\n1.입력\n2.수정\n3.삭제\n4.검색\n5.종료\n입력 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				select();
				break;
			case 5:
				sc.close();
				System.out.println("프로그램 종료!");
				System.exit(0);
			default:
				System.out.println("잘못된 입력!");
			}
		}
	}

	private void delete() {
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
//		for(PhoneBook pb : list) {
//			
//		}
		
		for(String group : list.keySet()) {
			ArrayList<PhoneBook> pbList = list.get(group);
			for(int i = 0; i < pbList.size(); i++) {
				if(pbList.get(i).getName().equals(name)) {
					pbList.remove(i);
					i--;
				}
			}
//			if(pbList.isEmpty()) {
//				list.remove(group);
//			}
		}
		
	}

	private void insert() {
		PhoneBook pb = new PhoneBook();
		System.out.print("이름 입력 : ");
		pb.setName(sc.next());
		boolean check = true;
		String an = null;
		while(true) {
			
			if(check) {
				System.out.print("전화번호를 추가하시겠습니까(Y/N)?");
				an = sc.next();
			}
			if(an.equals("N")) {
				break;
			}else if(!an.equals("Y")) {
				System.out.println("다시 입력해주십시오!");
			}else {
				PhoneNumber pn = this.inputNumber();
				if(pn == null) {
					System.out.println("전화번호를 다시 입력하십시오.");
					check = false;
				}else if(!pb.addPhoneNumber(pn)){
					break;
				}else {
					check = true;
				}
			}
		}
		
		System.out.print("저장할 그룹 입력 : ");
		String group = sc.next();
		ArrayList<PhoneBook> pbList = null;
		if(list.containsKey(group)) {
			pbList = list.get(group);
		}else {
			pbList = new ArrayList<PhoneBook>();
		}
		pbList.add(pb);
		
		list.put(group, pbList);
	}
	
	
	
	private PhoneNumber inputNumber() {
		PhoneNumber pn = null;
		try {
			System.out.println("전화번호 종류 선택");
			Kind.kindDisp();
			System.out.print("입력 : ");
			int kind = sc.nextInt();
			if(kind < 1 || kind > Kind.KIND.length) {
				throw new Exception("잘못입력하셨습니다.");
			}
			pn = new PhoneNumber();
			pn.setKind(Kind.KIND[kind - 1]);
			System.out.print("전화번호 입력 : ");
			pn.setNumber(sc.next());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return pn;
	}

	private void update() {
		while(true) {
			System.out.print("이름 입력 : ");
			String name = sc.next();
			
			PhoneBook pb = null;
			
			for(String group : list.keySet()) {
				ArrayList<PhoneBook> pbList = list.get(group);
				for(int i = 0; i < pbList.size(); i++) {
					if(pbList.get(i).getName().equals(name)) {
						pb = pbList.get(i);
						break;
					}
				}
			}
			
			pb.disp(1);
			
			System.out.print("1.번호추가\n2.번호수정\n3.번호삭제\n4.이전메뉴\n입력 : ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				addPhoneNumber(pb);
				break;
			case 2:
				updatePhoneNumber(pb);
				break;
			case 3:
				deletePhoneNumber(pb);
				break;
			case 4:
				System.out.println("이전메뉴로...");
				return;
			default:
				System.out.println("잘못된 입력!");
			}
		}
		
	}

	private void deletePhoneNumber(PhoneBook pb) {
		pb.numberDisp();
		if(pb.getNumberEA() == 0) {
			System.out.println("삭제할 전화번호가 없습니다.");
			return;
		}
		System.out.print("전화번호 선택 : ");
		int select = sc.nextInt();
		if(pb.getNumberEA() < select || select < 1) {
			System.out.println("선택을 잘못하였습니다.");
			return;
		}
		pb.deleteNumber(select - 1);
	}

	private void updatePhoneNumber(PhoneBook pb) {
		try {
			pb.numberDisp();
			if(pb.getNumberEA() == 0) {
				throw new Exception("수정할 전화번호가 없습니다.");
			}
			System.out.print("전화번호 선택 : ");
			int select = sc.nextInt();
			if(pb.getNumberEA() < select || select < 1) {
				throw new Exception("선택을 잘못하였습니다.");
			}
			
			PhoneNumber pn = inputNumber();
			
			pb.updateNumber(select - 1,pn);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private void addPhoneNumber(PhoneBook pb) {
		String an = null;
		boolean check = true;
		while(true) {
			try {
				if(check) {
					System.out.print("전화번호를 추가하시겠습니까(Y/N)?");
					an = sc.next();
				}
				if(an.equals("N")) {
					throw new Exception();
				}else if(!an.equals("Y")) {
					throw new Exception("다시 입력해주십시오!");
				}
				
				PhoneNumber pn = this.inputNumber();
				if(pn == null) {
					check = false;
					throw new Exception("전화번호를 다시 입력하십시오.");
				}
				
				if(!pb.addPhoneNumber(pn)){
					break;
				}else {
					check = true;
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void select() {
		while(true) {
			System.out.print("1.전화번호검색\n2.종류검색\n3.전체검색\n4.이전메뉴\n입력 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				numberSelect();
				break;
			case 2:
				kindSelect();
				break;
			case 3:
				allDisp();
				break;
			case 4:
				System.out.println("이전메뉴로...");
				return;
			default:
				System.out.println("잘못된 입력!");
			}
		}
	}

	private void kindSelect() {

		if(list.isEmpty()) {
			System.out.println("저장된 사람이 없습니다.");
		}else {
			System.out.println("전화번호 종류 선택");
			Kind.kindDisp();
			System.out.print("입력 : ");
			int select = sc.nextInt();
			
			for(String group : list.keySet()) {
				ArrayList<PhoneBook> pbList = list.get(group);
				System.out.println("===" + group + "===");
				for(int i = 0; i < pbList.size(); i++) {
					pbList.get(i).kindDisp(i, Kind.KIND[select - 1]);
				}
			}
			
//			for(int i = 0; i < list.size(); i++) {
//				list.get(i).kindDisp(i, Kind.KIND[select - 1]);
//			}
		}
	}

	private void numberSelect() {
		System.out.println("검색할 전화번호를 입력 : ");
		String number = sc.next();
		
		if(list.isEmpty()) {
			System.out.println("저장된 사람이 없습니다.");
		}else {
			
			for(String group : list.keySet()) {
				ArrayList<PhoneBook> pbList = list.get(group);
				System.out.println("===" + group + "===");
				for(int i = 0; i < pbList.size(); i++) {
					if(pbList.get(i).numberFind(number)) {
						pbList.get(i).disp(i + 1);
					}
				}
			}
//			for(int i = 0; i < list.size(); i++) {
//				if(list.get(i).numberFind(number)) {
//					list.get(i).disp(i + 1);
//				}
//			}
		}
		
	}

	private void allDisp() {
		if(list.isEmpty()) {
			System.out.println("저장된 사람이 없습니다.");
		}else {
			
			
			for(String group : list.keySet()) {
				ArrayList<PhoneBook> pbList = list.get(group);
				System.out.println("===" + group + "===");
				for(int i = 0; i < pbList.size(); i++) {
					pbList.get(i).disp(i + 1);
				}
			}
//			
//			for(int i = 0; i < list.size(); i++) {
//				list.get(i).disp(i + 1);
//			}
		}
	}
	
}

















