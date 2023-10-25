package array;

public class Test02 {

	public static void main(String[] args) {

//		[문제] Test02.java에 구현
//
//		주사위를 10번 던진 결과를 저장하려고 합니다
//		배열을 이용하여 저장을 구현하시고 아래의 결과를 출력하세요
//
//		[1] 전체 주사위 기록을 출력
//		   (예) 1번째 : 5 , 2번째 : 2, ...
//		[2] 짝수 주사위 기록을 출력
//		[3] 주사위 값들의 합계 출력
		
		
		int[] arr = new int[10];

		//주사위 10번 던진 결과 저장
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 6) + 1;
		}
		
		//전체 주사위 기록 출력 
		System.out.println("[1] 전체 주사위 기록을 출력");
		for(int i = 0; i < arr.length; i++) {
			if(i % 5 == 4) {
				System.out.println((i + 1) + "번째 : " + arr[i]);
			}else {
				System.out.print((i + 1) + "번째 : " + arr[i] + " , ");
			}
		}

		System.out.println("\n-----------------\n");
		
		//짝수 주사위 기록을 출력 
		int cnt = 0;
		System.out.println("[2] 짝수 주사위 기록을 출력");
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				if(cnt % 5 == 0) {
					System.out.print((i + 1) + "번째 : " + arr[i]);
				}else if(cnt % 5 == 4) {
					System.out.println(" , " + (i + 1) + "번째 : " + arr[i]);
				}else {
					System.out.print(" , " + (i + 1) + "번째 : " + arr[i]);
				}
				cnt++;
			}
		}
		
		System.out.println("\n-----------------\n");
		
		//주사위 값들의 합계 출력 
		System.out.println("[3] 주사위 값들의 합계 출력");
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println("총합 : " + total);
	}

}
















