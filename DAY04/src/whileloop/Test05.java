package whileloop;

public class Test05 {

	public static void main(String[] args) {
		
//		[문제] Test05.java 에 구현
//		[ 아이템 강화 시뮬레이션 ]
//		1. 아이템은 1번 강화하는데 현금 1000원이 필요하다
//		2. 아이템은 처음에 레벨이 0이다
//		3. 강화가 성공할 확률은 35% 이고 성공하면 레벨이 1 증가
//		4. 강화가 실패할 확률은 30% 이고 실패하면 레벨이 1 감소
//		5. 그 외의 경우에는 아무런 변화가 없다
//
//		0레벨의 아이템을 10레벨로 만들기 위해 내가 쏟아 부어야 되는 현금을 계산하세요		
		
		int lev = 0;
		int cnt = 0;
		int cost = 1000;
		int tot = 0;
		
		while(true) {
			double rate = Math.random();
			tot += cost;
			cnt++;
			
			if(rate < 0.35) {
				lev++;
				System.out.println(cnt + ". 강화 성공! +" + lev);
				if(lev == 10) {
					System.out.println("강화 완료!");
					System.out.println("총 강화 금액 : " + tot + "원");
					break;
				}
			}else if(rate >= 0.7) {
				if(lev == 0) {
					System.out.println(cnt + ". 강화 실패! 떨어질수가 없습니다. +" + lev);
					continue;
				}
				lev--;
				System.out.println(cnt + ". 강화 실패! +" + lev);
			}else {
				System.out.println(cnt + ". 아무런 변화가 없습니다. +" + lev);
			}
		}
		
		
	}
	
}
