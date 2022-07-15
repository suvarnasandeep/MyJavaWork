package CustomBlockingQueue;

public class Producer implements Runnable{

	MyBlockingQueue<String> queue;
	public Producer(MyBlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		 for(int i =0; i<15; i++){
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 queue.add(String.valueOf(i));
			 System.out.println("message produced :" + i);
		 }
		
	}

}
