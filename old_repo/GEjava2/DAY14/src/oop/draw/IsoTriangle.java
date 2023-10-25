package oop.draw;

public class IsoTriangle extends DrawData {
	
	public IsoTriangle(int hei, char ch) {
		super(hei, ch);
	}

	@Override
	public void draw() {
		int hei = getHei();
		char ch = getCh();
		for(int i = 0; i < hei; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
}
