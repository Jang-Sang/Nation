package switchcase;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		
//		국어, 영어, 수학 성적을 입력 받고 평균 점수를 구하고, 평균에 대한 학점을 
//		 출력하세요
//
//		  90이상 : A
//		  80이상 90미만 : B
//		  70이상 80미만 : C
//		  60이상 70미만 : D
//		  60미만 : F 
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int math = sc.nextInt();
		
		double avg = (kor + eng + math) / 3.0;
		
		switch((int)avg / 10) {
		case 10:
		case 9:
			System.out.println("학점 : A");
			break;
		case 8:
			System.out.println("학점 : B");
			break;
		case 7:
			System.out.println("학점 : C");
			break;
		case 6:
			System.out.println("학점 : D");
			break;
		default:
			System.out.println("학점 : F");
		}
		
	}
	
}


















