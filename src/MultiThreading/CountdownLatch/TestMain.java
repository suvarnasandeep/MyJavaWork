package CountdownLatch;
import java.util.concurrent.CountDownLatch;

public class TestMain {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(4);
		
		Thread thread1 = new Thread(new CountDownLatchDemo("service1", 1000, latch));
		Thread thread2 = new Thread(new CountDownLatchDemo("service2", 2000, latch));
		Thread thread3 = new Thread(new CountDownLatchDemo("service3", 3000, latch));
		Thread thread4 = new Thread(new CountDownLatchDemo("service4", 4000, latch));
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		System.out.println("main before await");
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main after await");

	}

}
