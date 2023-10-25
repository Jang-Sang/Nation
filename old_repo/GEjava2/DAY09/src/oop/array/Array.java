package oop.array;

public class Array {
//	Array라는 클래스를 구현하여 숫자 데이터가 저장되도록 구현
//	단, 자바에서 기본적으로 제공해주는 메소드는 사용하지 않고 구현.
	
//	(구성항목)		
//	배열, length(배열의 최대 개수) , size(현재 데이터 개수)
	private int[] arr; //setter,getter
	private int length; // setter,getter
	private int size; //getter
	
	public Array() {
		length = 10;
		arr = new int[length];
	}	
	
	public Array(int length) {
		this.setLength(length);
	}
	
	public Array(int[] arr) {
//		this.arr = arr;
//		length = 5;
		this.length = this.getLength(arr);
		this.arr = new int[length];
		for( ; size < arr.length; size++) {
			this.arr[size] = arr[size];
		}
	}
	
	public void setLength(int length) {
		if(length < 2) {
			System.out.println("길이는 2이상만 가능합니다.");
			return;
		}
		this.length = length;
		this.arr = new int[length];
	}
	
//	(기능)	
//	add(v)
//	- v라는 데이터를 마지막칸에 추가
	public boolean add(int v) {
		if(size == length) {
			return false;
		}
		
		arr[size] = v;
		size++;
		return true;
	}
//	add(i,v)
//  - i번째에 v데이터 삽입...
	public boolean add(int i,int v) {
		if(size == length) {
			return false;
		}else if(i < 0 || i >= size) {
			System.out.println("인덱스 범위가 벗어났습니다.");
			return false;
		}
		for(int idx = size-1; idx >= i; idx--) {
			arr[idx + 1] = arr[idx];
		}
		size++;
		arr[i] = v;
		return true;
	}
//	get(i)
//	- 특정 위치의 데이터 추출
//	- i번째 데이터 반환
	public int get(int i) {
		if(i < 0 || i >= size) {
			System.out.println("인덱스 범위가 벗어났습니다.");
			return 0;
		}
		return arr[i];
	}
//	indexOf(v)
//  - 데이터 검색후 데이터 위치반환 - 인덱스값 반환
	public int indexOf(int v) {
		for(int i = 0; i < size; i++) {
			if(arr[i] == v) {
				return i;
			}
		}
		return -1;
	}
	
//	remove()
//	- 마지막 데이터를 삭제
//	- 데이터 없으면 실행 중지
	public boolean remove() {
		if(size == 0) {
			return false;
		}
		size--;
		arr[size] = 0;
		return true;
	}
// remove(i)
//  - 인덱스 위치의 데이터 삭제
	public int remove(int idx) {
		if(!this.indexBounds(idx)) {
			return 0;
		}
		int v = arr[idx];
		for(int i = idx; i < size; i++) {
			arr[i] = arr[i + 1];
		}
		size--;
		arr[size] = 0;
		return v;
	}
	
// set(int i , int j)
//  - 데이터 서로 교환 , i 와 j 인덱스 위치의 v 교환
	public boolean set(int i,int j) {
		if(!this.indexBounds(i) || !this.indexBounds(j)) {
			return false;
		}
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return true;
	}

	private boolean indexBounds(int i) {
		if(i < 0 || i >= size) {
			System.out.println("인덱스 범위가 벗어났습니다.");
			return false;
		}
		return true;
	}
	
	private boolean indexOutOfBounds(int i) {
		if(i < 0 || i >= size) {
			System.out.println("인덱스 범위가 벗어났습니다.");
			return true;
		}
		return false;
	}
	
	//getter
	public int[] getArr() {
		return arr;
	}
	public int length() {
		return length;
	}
//	size()
//	- 현재 데이터의 개수를 반환
	public int getSize() {
		return size;
	}
	
	//user 메소드
	public int getLength(int[] arr) {
		return arr.length;
	}
	
	public void disp() {
		for(int i = 0; i < length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
	
	public void dataDisp() {
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
}
