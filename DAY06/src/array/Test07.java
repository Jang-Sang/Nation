package array;

public class Test07 {

	public static void main(String[] args) {

//		5x5 빙고판을 만드려고 합니다
//		
//		1부터 25까지의 숫자를 5x5 크기의 빙고판에 무작위로 배치하려고 합니다.
//		모든 자리에 숫자가 랜덤으로 배치될 수 있도록 코드 구현

		int[][] arr = new int[5][5];
		
		
		for(int i = 1; i <= 25; i++ ) {
			int r = (int)(Math.random() * 5);
			int c = (int)(Math.random() * 5);
			
			if(arr[r][c] == 0) {
				arr[r][c] = i;
			}else {
				i--;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
}
