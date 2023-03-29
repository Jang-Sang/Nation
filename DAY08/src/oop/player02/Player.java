package oop.player02;

public class Player {
//	[문제] oop.player02 패키지에 구현
//
//	Main.java	메인을 갖는 클래스
//	Player.java	게임 캐릭터 클래스
//	(구성항목)		아이디(id), 공격력(atk), 체력(hp), 공격대상(target) - String X
//			atk와 hp는 양수만 설정되도록 구현( > 0)
	
	private String id;
	private int atk,hp;
	private Player target;
	
	public Player(String id,int atk,int hp) {
		this.id = id;
		this.setAtk(atk);
		this.setHp(hp);
	}
	
	//setter
	public void setAtk(int atk) {
		if(atk <0) {
			System.out.println("잘못된 설정!");
			return;
		}
		this.atk = atk;
	}
	public void setHp(int hp) {
		if(hp <0) {
			System.out.println("잘못된 설정!");
			return;
		}
		this.hp = hp;
	}
	
	public void setTarget(Player target) {
		this.target = target;
	}
	
	
	//getter
	public String getId() {
		return id;
	}
	
	public int getAtk() {
		return atk;
	}
	
	public int getHp() {
		return hp;
	}
	
	public Player getTarget() {
		return target;
	}
	
	
	public void attack() {
		if(this.target != null) {
			target.hp -= this.atk;
		}else {
			System.out.println("대상이 없습니다.");
		}
	}
	
	public void disp() {
		System.out.println(id + "\t" + atk + "\t" + hp + "\t" + target.id);
	}	
//		id		atk	hp	공격대상
//[1]	뽀로로	10	100	타요
//[2]	타요	15	80	뽀로로
//[1]과 [2]를 생성하시고 정보를 출력한 뒤 서로 2번 공격하면 어떻게 되는지 구현
//attack()메소드를 Player에 추가한 다음
//공격하면 상대방의 체력이 내 공격력만큼 감소되도록 구현
}
