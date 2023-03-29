package switchcase;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키 입력 : ");
		String key = sc.next();
		
		// q w e r
		
		switch(key) {
		case "Q":
		case "q":
			System.out.println("SKILL1");
			break;
		case "W":
		case "w":
			System.out.println("SKILL2");
			break;
		case "E":
		case "e":
			System.out.println("SKILL3");
			break;
		case "R":
		case "r":
			System.out.println("SKILL4");
			break;
		default:
			System.out.println("잘못된 키 입력!!");
		}
		

	}

}
