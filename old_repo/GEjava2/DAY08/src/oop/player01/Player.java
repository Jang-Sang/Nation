package oop.player01;

public class Player {

//	[문제] oop.player01 패키지에 아래의 내용을 구현하세요
//	Main.java 	main
//	Player.java	게임 캐릭터 클래스(Player)
//		(항목)	아이디(id), 레벨(level), 공격력(attack), 체력(hp)
//		(메소드)	disp(정보출력), +@(필요하다면)
//		(생성자)	알아서
//		(특징)	1. 캐릭터 생성시 레벨은 1, 공격력 5, 체력 20
//				2. 레벨이 증가할 경우 공격력은 3, 체력은 10씩 증가
	
	private String id;
	private int lev = 1;
	private int atk = 5;
	private int hp = 20;
	
	private void init(String id) {
		this.id = id;
		this.lev = 1;
		this.atk = 5;
		this.hp = 20;
	}
	
	public Player(String id) {
		this.init(id);
//		this.id = id;
//		this.lev = 1;
//		this.atk = 5;
//		this.hp = 20;
	}
	
	public Player(String id,int lev) {
		this.init(id);
//		this.id = id;
//		this.lev = 1;
//		this.atk = 5;
//		this.hp = 20;
		this.setLev(lev);
	}
	
	//setter
	public void setLev(int lev) {
		if(this.lev >= lev) {
			return;
		}
		int gap = lev - this.lev;
		this.lev = lev;
		this.atk += (gap * 3);
		this.hp += (gap * 10);
	}
	
	//getter
	public String getId() {
		return id;
	}
	public int getLev() {
		return lev;
	}
	public int getAtk() {
		return atk;
	}
	public int getHp() {
		return hp;
	}
	
	//user 메소드
	public void levUp() {
		this.lev++;
		this.atk += 3;
		this.hp += 10;
	}
	
	public void disp() {
		System.out.println(id + "\t" + lev + "\t" + atk + "\t" + hp);
	}
	
//	아래의 항목을 만드시고 정보 출력
//		id	
//	[1]	공유		레벨 20으로 변경 후 정보 출력
//	[2]	아이유		레벨 15로 변경 후 정보 출력
//	[3]	유인나		레벨 30으로 변경 후 정보 출력	
	
	public static void main(String[] args) {
		
		Player p1 = new Player("공유");
		
		//p1.atk = 20;
		
		
		p1.disp();
		
		p1.setLev(20);
		
		p1.disp();
		
		Player p2 = new Player("아이유",15);
		
		p2.disp();
		
	}
	
}

























