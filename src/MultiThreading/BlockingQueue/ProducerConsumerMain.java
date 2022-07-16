package BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		
		Producer obj1 = new Producer(queue);
		Consumer obj2 = new Consumer(queue);
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start();
		t2.start();

	}

}
