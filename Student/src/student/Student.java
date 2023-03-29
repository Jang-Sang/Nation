package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import student.studentdtao.StudentDAO;
import student.studentdto.StudentDTO;

public class Student {

	private final Scanner sc = new Scanner(System.in);
	
	public Student() {
		menu();
	}
	
	private void menu() {
		while(true) {
			System.out.print("****************\r\n" + 
					"   관리\r\n" + 
					"****************\r\n" + 
					"  1. 입력\r\n" + 
					"  2. 수정 - 이름을 통해서 value 수정\r\n" + 
					"  3. 삭제\r\n" + 
					"  4. 검색\r\n" + 
					"  5. 종료\r\n" + 
					"****************\r\n" + 
					"  번호선택 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				insertArticle();
				break;
			case 2:
				updateArticle();
				break;
			case 3:
				deleteArticle();
				break;
			case 4:
				selectArticle();
				break;
			case 5:
				exit();
			default:
				System.out.println("잘못된 메뉴 입력!!!");
			}
		}
	}
	
	private void exit() {
		System.out.println("프로그램이 종료 됩니다!");
		sc.close();
		System.exit(0);
	}
	
	private String nameInput(String msg) {
		System.out.print(msg + "이름 입력 : ");
		return sc.next();
	}
	
	private int codeInput() {
		System.out.print("****************\r\n" + 
				"   1. 학생\r\n" + 
				"   2. 교수\r\n" + 
				"   3. 관리자\r\n" + 
				"   4. 이전메뉴\r\n" + 
				"****************\r\n" + 
				"   번호선택 : ");
		return sc.nextInt();
	}
	
	private String valueInput(int code) {
		if(code == 1) {
			System.out.print("학번 입력 : ");
		}else if(code == 2) {
			System.out.print("과목 입력 : ");
		}else if(code == 3){
			System.out.print("부서 입력 : ");
		}
		return sc.next();
	}
	
	private void insertArticle() {
		int code = this.codeInput();
		if(code < 1 || code > 4) {
			System.out.println("잘못된 입력!이전메뉴로...");
			return;
		}else if(code == 4) {
			System.out.println("이전 메뉴로...");
			return;
		}
		String name = nameInput("");
		String value = valueInput(code);
		
		StudentDTO dto = new StudentDTO(name, value, code);
		StudentDAO dao = new StudentDAO();
		
		int su = dao.insert(dto);
		
		if(su != 0) {
			System.out.println(name + "님의 정보가 추가 되었습니다.");
		}else {
			System.out.println("정보 추가에 실패 하였습니다.");
		}
	}

	private void deleteArticle() {
		String name = nameInput("삭제할 ");
		
		StudentDAO dao = new StudentDAO();
		
		int su = dao.delete(name);
		
		if(su != 0) {
			System.out.println(name + "님의 정보가 삭제 되었습니다.");
		}else {
			System.out.println("정보 삭제에 실패 하였습니다.");
		}
	}
	
	private void updateArticle() {
		String name = nameInput("수정할 ");
		
		StudentDAO dao = new StudentDAO();
		
		StudentDTO dto = dao.selectOne(name);
		
		if(dto == null) {
			System.out.println("정보가 없습니다!");
			return;
		}
		
		disp(dto);
		
		dto.setValue(valueInput(dto.getCode()));
		
		int su = dao.update(dto);
		
		if(su != 0) {
			System.out.println(name + "님의 정보가 수정 되었습니다.");
		}else {
			System.out.println("정보 수정에 실패 하였습니다.");
		}
	}
	
	private void disp(StudentDTO dto) {
		System.out.print(dto.getName() + "\t");
		if(dto.getCode() == 1) {
			System.out.println("학번 : " + dto.getValue());
		}else if(dto.getCode() == 2) {
			System.out.println("과목 : " + dto.getValue());			
		}else if(dto.getCode() == 3) {
			System.out.println("부서 : " + dto.getValue());			
		}
	}
	
	
	private void selectArticle() {
		System.out.print("****************\r\n" + 
				"   1. 이름 검색\r\n" + 
				"   2. 코드 검색\r\n" + 
				"   3. 전체 검색\r\n" + 
				"   4. 이전메뉴\r\n" + 
				"****************\r\n" + 
				"   번호선택 : ");
		int select = sc.nextInt();
	
		if(select < 1 || select > 4) {
			System.out.println("잘못된 입력!이전메뉴로...");
			return;
		}else if(select == 4) {
			System.out.println("이전 메뉴로...");
			return;
		}
		
		StudentDTO dto = null;
		
		if(select == 1) {
			dto = new StudentDTO();
			dto.setName(this.nameInput("검색할 "));
		}else if(select == 2) {
			int code = this.codeInput();
			if(code < 1 || code > 4) {
				System.out.println("잘못된 입력!이전메뉴로...");
				return;
			}else if(code == 4) {
				System.out.println("이전 메뉴로...");
				return;
			}
			dto = new StudentDTO();
			dto.setCode(code);
		}
		
		StudentDAO dao = new StudentDAO();
		
		List<StudentDTO> list = dao.select(dto);
		
		if(list == null) {
			System.out.println("데이터가 없습니다.");
		}else {
			for(int i = 0; i < list.size(); i++) {
				this.disp(list.get(i));
			}
		}
		
	}
}


























