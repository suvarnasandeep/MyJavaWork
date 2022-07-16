package CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain implements Runnable{
	public static CyclicBarrier barrier = new CyclicBarrier(3);

	public static void main(String[] args) {
		CyclicBarrierMain obj = new CyclicBarrierMain();
		Thread t1 = new Thread(obj);
		t1.start();
		System.out.println("before main await()");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println("main end");

		//cyclicbarrier example

		/*CyclicBarrier barie = new CyclicBarrier(4);

		Thread t1 = new Thread(new CyclicBarrierDemo(2000, barie, "thread1"));
		Thread t2 = new Thread(new CyclicBarrierDemo(2000, barie, "thread2"));
		Thread t3 = new Thread(new CyclicBarrierDemo(2000, barie, "thread3"));

		t1.start();
		t2.start();
		t3.start();

		try {
			barie.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("main thread end");*/
	}
	public void run() {
		System.out.println("number of parties = " +barrier.getParties());
		System.out.println("sum = " + SumComputation.sum + " product = " + ProductComputation.product);

		SumComputation obj1 = new SumComputation();
		ProductComputation obj2 = new ProductComputation();

		Thread t2 = new Thread(obj1);
		Thread t3 = new Thread(obj2);
		t2.start();
		t3.start();

		try {
			CyclicBarrierMain.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println("sum = " + SumComputation.sum + " product = " + ProductComputation.product);

		//CyclicBarrierMain.barrier.reset();
		System.out.println("barrier reset");
	}

}
