package oop.student02;

public class StudentEx extends Student{
//	저희 학원은 자바, C언어만 강의를 하고 있었습니다. 
//	장사가 너무 잘되서 파이썬 과목을 추가하기로 결정하였고 
//	관리 프로그램 클래스도 개량하여 사용하기로 하였습니다.	
//	(StudentEx 클래스)
//	(추가된 항목)
//		파이썬(python)	파이썬 과목 점수
	
	private int python;
	
	public StudentEx(String name,int java,int c,int python) {
		super(name, java, c);
		setPython(python);
	}
	
	public void setPython(int python) {
		this.python = python;
		setTot();
		setAvg();
	}
	
	public void setTot() {
		tot = getJava() + getC() + python;
	}
	
	public void setAvg() {
		avg = tot / 3.0;
	}
	
	public void disp() {
		System.out.println(getName() + "님의 성적정보");
		System.out.println("====================");
		System.out.println("java : " + getJava() + "점");
		System.out.println("c : " + getC() + "점");
		System.out.println("python : " + python + "점");
		System.out.println("====================");
		System.out.println("총점 : " + tot + "점");
		System.out.println("평균 : " + String.format("%.2f", avg) + "점");
	}

}
