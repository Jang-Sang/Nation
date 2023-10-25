package forloop;

public class Test01 {

	public static void main(String[] args) {

		int i = 0;
		for( ; true; ) {
			System.out.println(i);
			if(i == 2) {
				break;
			}
			i++;
		}
		
		
		//3번 반복하는 for문 작성
//		for(double i = -12.3; i > -12.8; i-=0.2) {
//			System.out.println(i);
//		}
		
		
		//일반적으로 많이 사용되는 형태
//		for(int i = 0; i < 3; i++) {
//			System.out.println(i);
//		}
		

	}

}
