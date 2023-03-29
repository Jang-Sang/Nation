package array;

import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int size = 0;
		do {
			System.out.println("정수 입력 : ");
			size = sc.nextInt();
		}while(size < 1);

		int[][] arr = new int[size][size];
		
		int x = 0,y = 0;
		
		int num = 1;
		int tot = size * size;
		
		while(num <= tot) {
			System.out.println(num);
			while(num <= tot) {
				arr[x][y] = num;
				num++;
				if(y == size - 1 || arr[x][y + 1] != 0) {
					x++;
					break;
				}
				y++;	
			}
			
			while(num <= tot) {
				arr[x][y] = num;
				num++;
				if(x == size - 1 || arr[x + 1][y] != 0) {
					y--;
					break;
				}
				x++;
			}
			
			while(num <= tot) {
				arr[x][y] = num;
				num++;
				if(y == 0 || arr[x][y - 1] != 0) {
					x--;
					break;
				}
				y--;
				
			}
			
			while(num <= tot) {
				arr[x][y] = num;
				num++;
				if(x == 0 || arr[x - 1][y] != 0) {
					y++;
					break;
				}
				x--;
			}
		}
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		sc.close();
	}

}


//package array;
//
//import java.util.Scanner;
//
//public class Test09 {
//
//	public static void main(String[] args) {
//		
//		//정사각형의 크기를 입력 받은 후 시계 방향으로 돌면서 다음과 같은 형태로 출력하는 프로그램을 작성하시오.
//		//
//		//가장 왼쪽 위의 좌표부터 차례로 숫자를 대입 시킨다.
//		//오른쪽으로 채워 나가다가 끝이면 다시 아래 > 왼쪽 > 위 > 오른쪽의 순으로 모두 채워질 때까지 반복한다.
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int size = 0;
//		do {
//			System.out.print("정사각형 크기 입력 : ");
//			size = sc.nextInt();
//		}while(size < 1);
//
//		int[][] arr = new int[size][size];
//
//		int e = size * size;
//		int x = 0, y = 0;
//		int min = 0, max = size - 1;
//				
//		for(int i = 1; i <= e; i++) {
//			arr[x][y] = i;
//			
//			if(x == min && y < max) {
//				y++;
//			}else if(x < max && y == max) {
//				x++;
//			}else if(x == max && y > min) {
//				y--;
//			}else if(x > min && y == min) {
//				x--;
//				if(x == min + 1) {
//					min++;
//					max--;
//				}
//			}
//		}
//		
//		for(int i = 0; i < size; i++) {
//			for(int j = 0; j < size; j++) {
//				System.out.print(arr[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		
//		sc.close();
//	}
//}

