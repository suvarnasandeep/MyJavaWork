package MultiThreading.ProducerConsumer;

import MultiThreading.ProducerConsumer.WaitAndNotify.ConsumeMessage;
import MultiThreading.ProducerConsumer.WaitAndNotify.ProduceMessage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		
		/*BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		
		Producer obj1 = new Producer(queue);
		Consumer obj2 = new Consumer(queue);
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start();
		t2.start();*/

		//test
		Queue<Integer> queue = new LinkedList<>();
		ProduceMessage obj = new ProduceMessage(queue, 10);
		ConsumeMessage obj1 = new ConsumeMessage(queue, 10);
		Thread t1 = new Thread(()->{
			for(int i=0; i<15; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.produce(i);
			}
		});

		Thread t2 = new Thread(()->{
			for(int i=0; i<15; i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj1.consume();
			}

		});

		t1.start();
		t2.start();
		System.out.println("main thread ended");

	}

}
