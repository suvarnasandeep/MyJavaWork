package ThreadExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0; i<10;i++){
			WorkerThread obj = new WorkerThread(" " +i);
			executor.execute(obj);
		}
		
		executor.shutdown();
		while(!executor.isShutdown()){
			
		}
		System.out.println("Thread finished");

	}

}
