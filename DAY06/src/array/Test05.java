package array;

public class Test05 {

	public static void main(String[] args) {

		int[][] arr = new int[3][4];
		
//		arr[0] = new int[7];
//		arr[1] = new int[5];
//		arr[2] = new int[3];
		
		System.out.println(arr);
		System.out.println(arr.length);
		
		System.out.println(arr[0]);
		System.out.println(arr[0].length);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
