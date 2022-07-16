package CountdownLatch;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo implements Runnable{

	public String name;
	public int timer;
	public CountDownLatch latch;
	
	public CountDownLatchDemo(String name, int timer, CountDownLatch latch) {
		this.name = name;
		this.timer = timer;
		this.latch = latch;
	}	
	
	@Override
	public void run() {
		try{
			Thread.sleep(timer);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(name + " is up");
		latch.countDown();
		
	}

}
