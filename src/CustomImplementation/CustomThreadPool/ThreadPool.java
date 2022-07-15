package CustomThreadPool;

public class ThreadPool {
	BlockingQueue<Runnable> queue;
	
	public ThreadPool(int queueSize, int nThread) {
		queue = new BlockingQueue<>(queueSize);
		
		String threadName = null;
		TaskExecutor task = null;
		
		for(int count = 1; count <= nThread; count++){
			threadName = "Thread - " + count;
			task = new TaskExecutor(queue);
			
			Thread thread = new Thread(task, threadName);
			thread.start();
		}
	}
	
	public void submitTask(Runnable task) throws InterruptedException {
		
		this.queue.enqueue(task);
	}
}
