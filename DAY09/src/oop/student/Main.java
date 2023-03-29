package oop.student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student("김민준",1,2,3);//3
		Student s2 = new Student("가",8,5,2);//1
		Student s3 = new Student("나",7,4,1);//2
		
//		s1.disp(1);
//		s2.disp(2);
//		s3.disp(3);
		
//		Student[] arr = new Student[] {s1,s2,s3};
		
//		for(int i = 0; i < arr.length; i++) {
//			int rank = 1;
//			for(int j = 0; j < arr.length; j++) {
//				if(arr[i].getTot() < arr[j].getTot()) {
//					rank++;
//				}
//			}
//			arr[i].setRank(rank);
//		}

		Class c = new Class();
		
		c.addStudent(s1);
		c.addStudent(s2);
		c.addStudent(s3);
		
		//c.list = new Student[1];
		
		Student[] list = c.getList();
		
		list = null;
		
		
		c.disp();
		
		c.setRank();
		
		c.disp();
		
		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i].disp(i + 1);
//		}
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("1.입력 2.출력 3.종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("국어 점수 입력 : ");
				int kor = sc.nextInt();
				System.out.print("영어 점수 입력 : ");
				int eng = sc.nextInt();
				System.out.print("수학 점수 입력 : ");
				int math = sc.nextInt();
				Student s = new Student(name, kor, eng, math);
				c.addStudent(s);
				c.setRank();
				break;
			case 2:
				c.disp();
				break;
			case 3:
				System.exit(0);//프로그램 종료 메소드
				// 0은 정상 종료 
				// 0이 아닌수 - 비정상종료
			default:
				System.out.println("잘못된 선택!");
			}
		}
		
	}
	
}






















