package WaitAndNotifyPC;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable{

	public List<Integer> taskQueue = new ArrayList<>();
	public int QUEUE_CAPACITY;
	
	public Producer(List<Integer>queue, int size) {
		this.taskQueue = queue;
		QUEUE_CAPACITY = size;
	}
	
	public void run() {
		
		int count = 0;
		while(true){
			try {
				produce(count);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
	}
	
	public void produce(int i) throws InterruptedException {
		synchronized (taskQueue) {
			if(taskQueue.size() == QUEUE_CAPACITY){
				System.out.println("task queue is full... " + Thread.currentThread().getName() + " waiting..");
				taskQueue.wait();
			}
			
			taskQueue.add(i);
			System.out.println("produced -- " + i);
			Thread.sleep(1000);
			taskQueue.notifyAll();
		}
		
	}
}
