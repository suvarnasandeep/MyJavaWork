package CustomBlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerMain {

	public static void main(String[] args) {
			
		//BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		MyBlockingQueue<String> queue = new MyBlockingQueue<>(5);
		
		Producer produce = new Producer(queue);
		Consumer consume = new Consumer(queue);
		
		new Thread(produce).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(consume).start();
		

	}

}
