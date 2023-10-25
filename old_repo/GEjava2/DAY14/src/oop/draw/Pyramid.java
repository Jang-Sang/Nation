package oop.draw;

public class Pyramid extends DrawData{

	public Pyramid(int hei, char ch) {
		super(hei, ch);
	}

	@Override
	public void draw() {
		int hei = getHei();
		char ch = getCh();
		for(int i = 0; i < hei; i++) {
			for(int j = 0; j < hei - i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < (i * 2) + 1; j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
}
