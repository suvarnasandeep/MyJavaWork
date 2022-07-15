package CustomThreadPool;

public class TaskExecutor implements Runnable{

	BlockingQueue<Runnable> queue;

	public TaskExecutor(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	public void run(){
		try {
			while(true){
				String name = Thread.currentThread().getName();

				Runnable task = queue.dequeue();
				
				System.out.println("Task started by :" +name);
				task.run();
				System.out.println("Task finished by :" +name);

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
