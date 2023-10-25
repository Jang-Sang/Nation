package vo.phone;

public class PhoneVO {
	private int phone_no;
	private String name;
	private String c_phone;
	private String h_phone;
	private String s_phone;

	public PhoneVO() {
		
	}
	
	
	
	public PhoneVO(int phone_no,String name,String c_phone,String h_phone,String s_phone) {
		super();
		this.phone_no = phone_no;
		this.name = name;
		this.c_phone = c_phone;
		this.h_phone = h_phone;
		this.s_phone = s_phone;
	}
	
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getC_phone() {
		return c_phone;
	}
	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}
	
	public String getH_phone() {
		return h_phone;
	}
	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
	}
	
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	
	
	
	
	
	
}