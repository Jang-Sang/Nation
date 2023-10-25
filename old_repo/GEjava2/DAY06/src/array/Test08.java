package array;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int size = 0;
		do {
			System.out.println("홀수 입력 : ");
			size = sc.nextInt();
		}while(size % 2 == 0);
		
		int[][] arr = new int[size][size];
		
		int e = size * size;
		
		int x = 0;
		int y = size / 2;
		
		for(int i = 1; i <= e; i++) {
			arr[x][y] = i;
			
			if(i % size == 0) { 
				x++;
			}else {
				x--;
				y--;
				if(x < 0) x = size - 1;
				if(y < 0) y = size - 1;
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

















