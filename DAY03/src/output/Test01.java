package output;

public class Test01 {

	public static void main(String[] args) {
		
		//I/O - Input/Output - 입출력
		//CPU기준 데이터가 들어가면 input 데이터가 나가면 ouput
		
		// stream 
		// - JAVA에서 데이터를 주고받기위한 통로
		// - 모든 IO는 stream을 통해서 한다. 표준 입출력을 제외한 모든 IO에서는
		//   stream을 직접만들어주어야 한다.
		
		// 표준 입출력
		// System.out - 표준 출력 스트림(객체)
		// System.in - 표준 입력 스트림(객체)
		
		// System.out
		
		// .println - 출력후 엔터
		System.out.println(".println - ");
		System.out.println("출력후 엔터");
		
		// .print - 출력만
		System.out.print(".print - ");
		System.out.println("출력만");
		
		// .printf() - 출력형식을 정해서 출력시키는 메소드 - X - C언어 잔재....
		//  - String.format() - 
		
	}
	
}
