package ThreadExecutor;

public class WorkerThread implements Runnable{
	String command;
	
	public WorkerThread(String cmd) {
		command = cmd;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() +"-> " + command);
		processThread();
		System.out.println(Thread.currentThread().getName() + "-> "+"ends");
	}
	
	public void processThread() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
