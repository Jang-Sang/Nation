package oop.student;

public class Student {
	
//	성적관리프로그램
//	이름 , 국어 ,영어,수학 , 총점 , 등수
//	를 저장하고 관리할수 있는 클래스를 만드십시오.

	private String name = null;
	private int kor = 0,eng,math,tot,rank;

	//생성자
	public Student() {
		
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name,int kor,int eng,int math) {
		System.out.println(this.name);
		this.name = name;
		System.out.println(this.name);
		this.setKor(kor);
		this.setEng(eng);
		this.setMath(math);
		Class.addSu();
	}
	
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		if(kor < 0 || kor > 100) {
			System.out.println("잘못된 점수!");
			return;
		}
		this.kor = kor;
		setTot();
	}
	public void setEng(int eng) {
		if(eng < 0 || eng > 100) {
			System.out.println("잘못된 점수!");
			return;
		}
		this.eng = eng;
		setTot();
	}
	public void setMath(int math) {
		if(math < 0 || math > 100) {
			System.out.println("잘못된 점수!");
			return;
		}
		this.math = math;
		setTot();
	}
	
	public void setTot() {
		this.tot = kor + eng + math;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	//getter
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public int getRank() {
		return rank;
	}
	

	//user 메소드
	public void disp() {
		System.out.println(name + "님의 성적");
		System.out.println("=================");
		System.out.println("국어 : " + kor + "점");
		System.out.println("영어 : " + eng + "점");
		System.out.println("수학 : " + math + "점");
		System.out.println("=================");
		System.out.println("총점 : " + tot + "점");
		System.out.println("순위 : " + rank + "등");
	}
	
	public void disp(int i) {
		System.out.println("[" + i + "]\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + rank);
	}
	
}
