import java.util.Scanner;

import dbtest.dbtestdao.DBTestDAO;
import dbtest.dbtestdto.DBTestDTO;

public class Insert {

	public static void main(String[] args) {
		
		DBTestDAO dao = new DBTestDAO();
		
		dao.select();
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("이름 입력 : ");
//		String name = sc.next();
//		System.out.print("나이 입력 : ");
//		int age = sc.nextInt();
//		System.out.print("키 입력 : ");
//		double height = sc.nextDouble();
//		
//		sc.close();
//		
//		DBTestDTO dto = new DBTestDTO(name, age, height);
//		
//		DBTestDAO dao = new DBTestDAO();
//		
//		int su = dao.insert(dto);
//		
//		if(su != 0) {
//			System.out.println(name + "님의 정보가 추가되었습니다.");
//		}else {
//			System.out.println(name + "님의 정보 추가에 실패하였습니다.");
//		}
	}
	
}
