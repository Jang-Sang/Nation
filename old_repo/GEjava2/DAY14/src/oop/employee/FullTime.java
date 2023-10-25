package oop.employee;

public class FullTime extends Employee{

//	# ------------정규사원---------------
//	# 성명 : 홍길동
//	# 주민등록번호 : 901012-1234567
//	# 사원 코드 : 20061201
//	# 기본급 : 1500000
//	# 수당 : 700000
//	# 실제 급여 : 2200000
	
	private String code;
	private int basePay;
	private int benefit;
	private int salay;
	
	public FullTime(String name,String rrn,String code,int basePay,int benefit) {
		super(name, rrn);
		this.code = code;
		this.basePay = basePay;
		this.benefit = benefit;
		this.salay = this.basePay + this.benefit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getBasePay() {
		return basePay;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
		setSalay();
	}

	public int getBenefit() {
		return benefit;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

	public int getSalay() {
		return salay;
	}

	public void setSalay() {
		this.salay = this.basePay + this.benefit;
	}
	
	public void disp() {
		System.out.println("------------정규사원---------------");
		super.disp();
		System.out.println("사원 코드 : " + code);
		System.out.println("기본급 : " + basePay + "원");
		System.out.println("수당 : " + benefit + "원");
		System.out.println("총 급여 : " + salay + "원");
	}
	
}

























