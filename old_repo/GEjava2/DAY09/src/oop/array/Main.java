package oop.array;

public class Main {

	public static void main(String[] args) {
		
		//int[] ar = new int[] {1,2,3};
		
		//Array arr = new Array(ar);
		
		Array arr = new Array(7);
		
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		
		arr.add(2,5);
		
		//ar[3] = 30;
		
		System.out.println(arr.length());
		
		arr.disp();
		
		arr.dataDisp();
		
		//System.out.println(arr.indexOf(10));
	}
	
}
