package ProducerConsumer.WaitAndNotify;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable{

	List<Integer> taskQueue = new ArrayList<>();
	
	public Consumer(List<Integer> queue) {
	this.taskQueue = queue;
	}

	@Override
	public void run() {
		
		while(true){
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void consume() throws InterruptedException {
		
		synchronized (taskQueue) {
			if(taskQueue.isEmpty()){
				System.out.println("task queue is empty..." + Thread.currentThread().getName() + " waiting..");
				taskQueue.wait();
			}
			
			int var = taskQueue.get(0);
			taskQueue.remove(0);
			System.out.println("consumer -- "+var);
			Thread.sleep(2000);
			taskQueue.notifyAll();
		}
		
	}
	
	
}
