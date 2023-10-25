package oop.employee;

public class PartTime extends Employee{
//	# ------------임시사원---------------
//	# 성명 : 김초아
//	# 주민등록번호 : 920712-2345678
//	# 일당급여액 : 50000
//	# 근무일수 : 20
//	# 실제 급여 : 1000000
	private int dayPay;
	private int day;
	private int salary;
	
	public PartTime(String name,String rrn,int dayPay,int day) {
		super(name, rrn);
		this.dayPay = dayPay;
		this.day = day;
		this.salary = this.dayPay * this.day;
	}

	public int getDayPay() {
		return dayPay;
	}

	public void setDayPay(int dayPay) {
		this.dayPay = dayPay;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary() {
		this.salary = this.dayPay * this.day;
	}
	
	public void disp() {
		System.out.println("------------임시사원---------------");
		super.disp();
		System.out.println("일당급여액 : " + dayPay + "원");
		System.out.println("근무일수 : " + day + "일");
		System.out.println("실제급여 : " + salary + "원");
	}
	
	
}




















