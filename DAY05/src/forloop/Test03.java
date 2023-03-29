package forloop;

public class Test03 {

	public static void main(String[] args) {
		
//		[문제] Test03.java에 구현
//
//		돈을 저축하려 합니다
//		오늘 저축할 돈은 어제 저축한 돈의 두배로 할 예정이고
//		첫째날에 1원을 저축하려고 합니다
//
//		(Q1)	30일동안 통장에 저축될 돈은 얼마입니까?
//		int cost = 1;
//		int tot = 0;
		
//		for(int i = 1,cost = 1,tot = 0; i <= 30; cost *= 2,i++) {
//			tot += cost;
//			System.out.println(i + "일째 저축 금액 : " + cost + "원\t총 저축 금액 : " + tot + "원");
////			cost *= 2;
//		}
		
//		(Q2)	40일동안 통장에 저축될 돈은 얼마입니까?		
		
		long cost = 1;
		long tot = 0;
		int i = 1;
		for(cost = 1,tot = 0,i = 1; i <= 40; cost *= 2,i++) {
			tot += cost;
			System.out.println(i + "일째 저축 금액 : " + cost + "원\t총 저축 금액 : " + tot + "원");
//			cost *= 2;
		}
		
	}
	
}











