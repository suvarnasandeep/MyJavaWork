package ProducerConsumer.WaitAndNotify;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		List<Integer> taskQueue = new ArrayList<>();
		
		Thread producerThread = new Thread(new Producer(taskQueue, 5), "producer-thread");
		
		Thread consumerThread = new Thread(new Consumer(taskQueue), "consumer-thread");
		
		producerThread.start();
		consumerThread.start();

	}

}
