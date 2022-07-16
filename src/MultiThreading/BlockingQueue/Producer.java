package BlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	BlockingQueue<Message> queue;
	
	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}
		
	public void run() {
		for(int i = 0; i< 50; i++){
			Message obj = new Message(""+i);			
			try {
				queue.put(obj);
				System.out.println("msg produced" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Message obj = new Message("exit");
		try {
			queue.put(obj);
			System.out.println("exit msg produced");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
