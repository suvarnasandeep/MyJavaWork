package CallableAndFuture;

import java.util.concurrent.Callable;

public class WorkerCallable implements Callable<String>{

	public String call(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Thread.currentThread().getName();
	}
}
