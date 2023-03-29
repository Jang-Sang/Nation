import java.util.ArrayList;
import java.util.List;

class NumberSaver extends Thread{
	List<Integer> li;
	
	public NumberSaver(List<Integer> li) {
		this.li = li;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 10000; i++) {
			synchronized (li) {
				li.add(i);
				li.get(i);
			}
		}
		
		String name = getName();
		System.out.println("[" + name + "] size = " + li.size());
		
	}
}

public class Test03 {

	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> li = new ArrayList<Integer>();
		
		NumberSaver t1 = new NumberSaver(li);
		NumberSaver t2 = new NumberSaver(li);
		
		t1.start();
		t2.start();
		
		t1.join(1000);
		
		System.out.println(li.size());
	}
	
}
