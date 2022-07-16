package BlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	public BlockingQueue<Message> queue;
	
	public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}
	
	public void  run() {
		Message msg;
		try {
			while((msg = queue.take()).getMsg() != "exit"){
				Thread.sleep(5000);
				System.out.println("msg comsumer" + msg.getMsg());
			}
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}
