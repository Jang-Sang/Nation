package oop.inner01;

public class Suit {

	int price;
	Top t = new Top();
	Bottom b = new Bottom();
	
	public Suit() {

		t.price = 10;
	}
	
	
	public static class Top{
		/* private */int price;
	}
	
	private class Bottom{
		int price;
	}

}
