package CustomThreadPool;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<Type> {

	Queue<Type> queue = new LinkedList<>();
	private int QUEUE_SIZE = 1;

	public BlockingQueue(int size) {
		this.QUEUE_SIZE = size;
	}

	public synchronized void enqueue(Type task) throws InterruptedException{

		while(this.queue.size() == QUEUE_SIZE){
			wait();

		}

		if(this.queue.size() == 0){
			notifyAll();
		}
		
		queue.offer(task);

	}
	
	public synchronized Type dequeue() throws InterruptedException {
		
		while(this.queue.size() == 0){
			wait();
		}
		
		if(this.queue.size() == QUEUE_SIZE){
			notifyAll();
		}
		
		return this.queue.poll();
		
	}
}
