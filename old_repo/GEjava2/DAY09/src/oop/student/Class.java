package oop.student;

//한 반을 관리하는 클래스
public class Class {

	private Student[] list = new Student[10];
	private static int su;
	
	public Class() {
		
	}
	
	
	public static void addSu() {
		su++;
	}
	
	public Student[] getList() {
		return list;
	}
	
	public void addStudent(Student s) {
		list[su] = s;
	}
	
	public void setRank() {
		for(int i = 0; i < su; i++) {
			int rank = 1;
			for(int j = 0; j < su; j++) {
				if(list[i].getTot() < list[j].getTot()) {
					rank++;
				}
			}
			list[i].setRank(rank);
		}
	}
	
	public void disp() {
		for(int i = 0; i < su; i++) {
			list[i].disp(i + 1);
		}
	}
}
