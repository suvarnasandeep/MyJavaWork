package CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ProductComputation implements Runnable {
	public static int product = 0;
	
	public void run() {
		System.out.println("Is the barrier broken? - " + CyclicBarrierMain.barrier.isBroken());
		product = 3*3;
		try {
			System.out.println("Number of parties waiting at the barrier "+
		            "at this point = " + CyclicBarrierMain.barrier.getNumberWaiting());
			CyclicBarrierMain.barrier.await();
			System.out.println("Number of parties waiting at the barrier "+
		            "at this point = " + CyclicBarrierMain.barrier.getNumberWaiting());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		} 
	}
}
