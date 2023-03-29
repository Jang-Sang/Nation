package oop.employee;

public class Employee {
	
	private String name;
	private String rrn;
	
	public Employee(String name,String rrn) {
		this.name = name;
		this.rrn = rrn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	
	public String getName() {
		return name;
	}
	public String getRrn() {
		return rrn;
	}
	
	public void disp() {
		System.out.println("성명 : " + name);
		System.out.println("주민등록번호 : " + rrn);
	}
	
//	# 사원 클래스(Employee)를 만들고, 사원 클래스를 상속받는 정규직 사원 클래스(FullTime)와 임시사원 클래스(PartTime)를 만들어 보자.
//	# - 정규사원의 실제 급여는 기본급에 수당을 합해서 구한다. 
//	# - 임시사원의 실제 급여는 일당급여액에 근무일수를 합해서 구한다.

//	# ------------정규사원---------------
//	# 성명 : 홍길동
//	# 주민등록번호 : 901012-1234567
//	# 사원 코드 : 20061201
//	# 기본급 : 1500000
//	# 수당 : 700000
//	# 실제 급여 : 2200000
//	# ------------임시사원---------------
//	# 성명 : 김초아
//	# 주민등록번호 : 920712-2345678
//	# 일당급여액 : 50000
//	# 근무일수 : 20
//	# 실제 급여 : 1000000
}
