package ThreadJoin;

public class ThreadIntrrupt implements Runnable{

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			try {
				Thread.sleep(500);
				System.out.println("x");
			} catch (InterruptedException e) {		
				System.out.println(Thread.currentThread().getName() + "intrrupted");
				e.printStackTrace();
			}
		}
		
	}

}
