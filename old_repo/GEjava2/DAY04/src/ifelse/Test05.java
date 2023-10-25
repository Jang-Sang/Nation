package ifelse;

public class Test05 {

	public static void main(String[] args) {
		
//		[문제] Test05.java에 구현
//
//		주사위를 2개 던지는 코드를 구현하시고
//		두개의 주사위 합계에 따라 아래와 같이 코드를 구현
//
//		(1) 합계가 짝수일 경우		짝! 출력
//		(2) 합계가 홀수일 경우		홀! 출력
//		(3) 두 주사위가 같은 값일 경우 		더블! 출력
		
		int a = (int)(Math.random() * 6) + 1;
		int b = (int)(Math.random() * 6) + 1;
		
		int tot = a + b;

		if(tot % 2 == 0) {
			if(a==b) {
				System.out.println("더블!");
			}else {
				System.out.println("짝!");
			}
		}else {
			System.out.println("홀!");
		}
		
		
//		if(a == b) {
//			System.out.println("더블!");
//		}else if(tot % 2 == 0) {
//			System.out.println("짝!");
//		}else {
//			System.out.println("홀!");
//		}
		
		
	}
	
}
