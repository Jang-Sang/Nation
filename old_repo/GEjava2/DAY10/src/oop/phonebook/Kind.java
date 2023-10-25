package oop.phonebook;

public class Kind {
	public static final String PHONE = "핸드폰";
	public static final String HOME = "집";
	public static final String COMPANY = "회사";
	
	public static final String[] KIND = new String[] {"핸드폰","집","회사"};
	
	public static void kindDisp() {
		for(int i = 0; i < Kind.KIND.length; i++) {
			System.out.println(i + 1 + ". " + Kind.KIND[i]);
		}
	}
}
