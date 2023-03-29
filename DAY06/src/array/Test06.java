package array;

public class Test06 {

	public static void main(String[] args) {
//		아래의 형태가 되도록 2차원 배열을 구성하여 값을 대입 후 출력
//		1	6	11	16	21
//		2	7	12	17	22
//		3	8	13	18	23
//		4	9	14	19	24
//		5	10	15	20	25
		
		int row = 5;
		int col = 5;
		
		int[][] arr = new int[row][col];
		
	
		for(int i = 0, cnt = 1; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; cnt++, j++) {
				arr[j][i] = cnt;
			}
		}
		
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
