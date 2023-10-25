package oop.student02;

public class Student {

	private String name;
	private int java;
	private int c;
	protected int tot;
	protected double avg;
	
	public Student(String name,int java,int c) {
		this.name = name;
		this.setJava(java);
		this.setC(c);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
		setTot();
		setAvg();
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
		setTot();
		setAvg();
	}
	public int getTot() {
		return tot;
	}
	public void setTot() {
		this.tot = java + c;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = tot / 2.0;
	}
	
	public void disp() {
		System.out.println(name + "님의 성적정보");
		System.out.println("====================");
		System.out.println("java : " + java + "점");
		System.out.println("c : " + c + "점");
		System.out.println("====================");
		System.out.println("총점 : " + tot + "점");
		System.out.println("평균 : " + avg + "점");
	}
	
}

















