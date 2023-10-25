package oop.draw;

public abstract class DrawData {

	private int hei;
	private char ch;
	
	public DrawData(int hei, char ch) {
		super();
		this.hei = hei;
		this.ch = ch;
	}
	
	public int getHei() {
		return hei;
	}
	public void setHei(int hei) {
		this.hei = hei;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	
	public abstract void draw();
	
//	도형을 그리는 프로그램을 작성해보자.
//	(1) 도형의 높이와 출력문자를 입력받아 도형을 그리는 프로그램이다.
//	(2) 상속을 이용하여 다형성을 구현한다.
//	
//	1.DrawData 클래스 - 추상클래스
//	 - 높이와 출력문자
//	 - draw() - 추상메소드
//	2.IsoTriangle 클래스
//	 - 삼각형 그리는 클래스
//	 - draw() - 오버라이드
//	3.Pyramid 클래스 
//	 - 피라미드를 그리는 메소드
//	 - draw() - 오버라이드	 
//	 (출력 결과)
//	 x
//	 xx
//	 xxx
//	 xxxx
//	 xxxxx
//	 xxxxxx
//	 xxxxxxx
//	 xxxxxxxx
//	 xxxxxxxxx
//	 xxxxxxxxxx
	
//	          #
//	         ###
//	        #####
//	       #######
//	      #########
//	     ###########
//	    #############
//	   ###############
//	  #################
}
