import java.util.Random;

import javax.swing.JDialog;

class Terror implements Runnable{

	String t;
	public Terror(String t) {
		this.t = t;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 10; i++) {
			JDialog d = new JDialog();
			d.setTitle(t);
			int s = 200 + new Random().nextInt(201); // 200 ~ 400
			int x = new Random().nextInt(1001); // 0 ~ 1000
			d.setSize(s, s);
			d.setLocation(x + 2000,x);
			d.setVisible(true); // 창 보이기
		}
		
	}
	
}

public class Test04 {

	public static void main(String[] args) {
		
		Terror r = new Terror("T E R R O R");
		//r.run();
		Thread t = new Thread(r);
		t.start();
		
		Thread t2 = new Thread() {
				@Override
				public void run() {

				}
		};
		t2.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 10; i++) {
					System.out.println("!!!!");
				}
			}
		}).start();
		
	}
	
}










