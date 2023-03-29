package ifelse;

public class Test04 {

	public static void main(String[] args) {
		
		//Math.random()
		// - 0부터 1미만의 임의의 실수를 구하는 메소드...
		
		//범위안의 임의의 수 구하기
		// (int)(Math.random() * 범위 안에 수의 개수) + 시작수
		
		// 6 ~ 8
		
		double a = Math.random(); // 0.0000 ~ 0.9999
		double b = a * 3; // 0.0000 ~ 2.9999
		int c = (int)b; // 0 ~ 2
		int d = c + 6; // 6 ~ 8
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		int r = (int)(Math.random() * 3) + 6;
		
		System.out.println(r);

	}

}
