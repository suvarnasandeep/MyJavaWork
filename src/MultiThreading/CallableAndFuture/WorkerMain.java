package CallableAndFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class WorkerMain {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		List<Future<String>> list = new ArrayList<>();
		WorkerCallable task = new WorkerCallable();
		
		for(int i=0; i<=10; i++){
			Future<String> res = executor.submit(task);
			list.add(res);
		}
		
		for(Future<String> fut : list){
			try {
				System.out.println("--> " + fut.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executor.shutdown();

	}

}
