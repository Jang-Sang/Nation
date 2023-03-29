package oop.draw;

public class Main {

	public static void main(String[] args) {
		
		DrawData d = new IsoTriangle(8, '*');
		
		d.draw();
		
		d = new Pyramid(8, '#');
		
		d.draw();
	}

}
