package ThreadBasic;

public class StopThreadDemo implements Runnable{

	private volatile boolean tStop = false;
	
	public void run(){
		
		while(!tStop){
			System.out.println("Thread is running");
		}
		
		System.out.println("thread is going to stop");
	}
	
	
	public void threadStop() {
		tStop = true;
	}
}
