package CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class SumComputation implements Runnable {
	public static int sum = 0;
	
	public void run() {
		sum = 10+20;		
		try {
			System.out.println("sum start");
			CyclicBarrierMain.barrier.await();
			System.out.println("sum end");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	
}
