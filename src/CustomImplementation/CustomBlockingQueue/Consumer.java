package CustomBlockingQueue;

public class Consumer implements Runnable{

	MyBlockingQueue<String> queue;
	
	public Consumer(MyBlockingQueue<String>queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i=0; i<15; i++){
			Object data = queue.poll();
			
			if(data != null){
				System.out.println("data is consumed :" +data.toString());
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
