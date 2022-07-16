package ThreadBasic;

public class ThreadJoinDemo implements Runnable{

	private Thread predecessor;
	
	public void run(){
		System.out.println("thread " + Thread.currentThread().getName() + "started");
		try{
			//Thread.sleep(2000);
			
			if(predecessor != null){
				predecessor.join();
			}
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("thread " + Thread.currentThread().getName() + "ended");
		
	}
	
	public void setPredecessor(Thread t) {
		this.predecessor = t;
	}
}
