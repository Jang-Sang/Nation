// Thread
// - 두개 이상의 코드를 동시에 실행할수 있도록 만드는 것...
//
public class Test02 {

	public static void main(String[] args) {
		
		for(char c = '가'; c < '나'; c++) {
			System.out.print(c);
		}
		System.out.println();
		for(char c = '나'; c < '다'; c++) {
			System.out.print(c);			
		}
		
	}
	
}
