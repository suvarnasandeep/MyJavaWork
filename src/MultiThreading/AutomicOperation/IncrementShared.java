package AutomicOperation;
import java.util.concurrent.atomic.AtomicInteger;

public class IncrementShared implements Runnable{

	private AtomicInteger count = new AtomicInteger(0);
	
	public void run() {
		for(int i = 0; i <5; i++){
			doSomething(i);
			count.incrementAndGet();
		}
		
	}
	
	public void doSomething(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getCount() {
		return count.get();
	}

}
