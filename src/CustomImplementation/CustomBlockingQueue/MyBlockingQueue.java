package CustomBlockingQueue;
import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue <E>{

	private List<E> queue = new LinkedList<>();
	private final int size;

	public MyBlockingQueue(int size) {
		this.size = size;
	}
	
	public synchronized boolean add(E element) {
		
		while(queue.size() == this.size){
			try {
				wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
		if(queue.size() == 0){
			notifyAll();
		}
		
		boolean result = this.queue.add(element);
		return result;
	
	}
	
	public synchronized E poll() {
		while(this.queue.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(this.queue.size() == size){
			notifyAll();
		}
		
		return queue.remove(0);
	}
}
