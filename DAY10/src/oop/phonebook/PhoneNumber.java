package oop.phonebook;


//PhoneNumber - 전화번호 관리 클래스 - 집 : 052-260-6038...
public class PhoneNumber {

	private String kind;
	private String number;
	
	public PhoneNumber() {
		
	}
	
	public PhoneNumber(String kind) {
		this.kind = kind;
	}
	
	public PhoneNumber(String kind,String number) {
		this.kind = kind;
		this.number = number;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getKind() {
		return kind;
	}
	public String getNumber() {
		return number;
	}
	
	public void disp() {
		System.out.println(kind + " : " + number);
	}
	
	public boolean numberContains(String number) {
		return this.number.contains(number);
//		if(this.number.contains(number)) {
//			return true;
//		}else {
//			return false;
//		}
	}
	
	public boolean kindContians(String kind) {
		if(this.kind.equals(kind)) {
			return true;
		}else {
			return false;
		}
	}
	
}














