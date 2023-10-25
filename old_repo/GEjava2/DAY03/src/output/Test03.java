package output;

public class Test03 {

	
	public static void main(String[] args) {
		
		// .printf('문자열형식',데이터.....)
		
		int a = 10;
		int b = 10;
		
		System.out.println("a = " + a);
		
		System.out.printf("a = %d\n",a);
		
		System.out.println(String.format("a = %d", a));
		
		//서식문자
		// - 어떤 타입으로 설정할지 정하는 문자
		// - 데이터를 넣고자 하는 위치에 %를 적고 형식에 맞는 문자를 적어주면 된다...
		
		// ※ 서식문자와 입력되는 데이터의 관계는 반드시 1:1로 매칭되어야 한다...
		//   개수가 동일해야하며 형식이 일치되어야 정상적으로 사용가능하다..
		
		// - 종류
		//  - %d - 정수
		System.out.printf("%d + %d = %d\n",a,b,a + b);
		//  - %f - 실수
		//	 - %f를 사용할때는 실수의 기본 출력형식이 소수점 6번째 자리까지 출력된다..
		System.out.printf("%f\n",123.456);
		
		//  - %c - 문자
		System.out.printf("%c, %d\n",'A',(byte)'A');
		//  - %s - 문자열
		System.out.printf("%s\n","안녕하세요");
		
		//  - %o - 8진수
		//  - %x - 16진수 - 소문자 출력시 소문자 대문자 출력시 대문자로...
		System.out.printf("%o %X\n",127,127);
		System.out.printf("%o %X\n",0127,0x127);
		
		System.out.println(Integer.toBinaryString(15));
		System.out.println(Integer.toOctalString(15));
		System.out.println(Integer.toHexString(15));
		
		//※ 컴퓨터에서 사용되는 진법
		// 2진수		0 , 1			X			X
		// 8진수		0 ~ 7			%o			010
		// 10진수		0 ~ 9			%d			10
		// 16진수		0 ~ 9 , A ~ F	%x			0x10
		

		//확장형 서식문자
		System.out.println("|12345|");
		System.out.printf("|%05d|\n",10);
		System.out.printf("|%-5d|\n",10);
		
		System.out.printf("|%13.5f|\n",123.456);
		System.out.printf("|%.2f|\n",123.456);
		System.out.printf("|%-10.2f|\n",123.456);
	}
	
}


























