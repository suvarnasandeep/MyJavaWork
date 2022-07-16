package CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo implements Runnable{

	int timer;
	CyclicBarrier bar;
	String name;
	
	public CyclicBarrierDemo(int timer, CyclicBarrier barrier, String name) {
		this.timer = timer;
		bar = barrier;
		this.name = name;
	}
	
	public void run(){
		System.out.println(name +" is calling await");
		try {
			Thread.sleep(timer);
			bar.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name +" has broken barrier");
		
	}
}
