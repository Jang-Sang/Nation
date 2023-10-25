package oop.player02;

public class Main {

	public static void main(String[] args) {
		
//		id		atk	hp	공격대상
//[1]	뽀로로	10	100	타요
//[2]	타요	15	80	뽀로로
//[1]과 [2]를 생성하시고 정보를 출력한 뒤 서로 2번 공격하면 어떻게 되는지 구현
//	attack()메소드를 Player에 추가한 다음
//	공격하면 상대방의 체력이 내 공격력만큼 감소되도록 구현
		
		Player p1 = new Player("뽀로로", 10, 100);
		Player p2 = new Player("타요", 15, 80);
		
		
		p1.setTarget(p2);
		p2.setTarget(p1);
		
		p1.disp();
		p2.disp();
		
		p1.attack();
		p1.attack();
		p2.attack();
		p2.attack();

		p1.disp();
		p2.disp();
	}
	
}
