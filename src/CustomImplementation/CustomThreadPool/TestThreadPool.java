package CustomThreadPool;

public class TestThreadPool {

	public static void main(String[] args) throws InterruptedException {

		ThreadPool pool = new ThreadPool(3, 1);
		
		for(int i = 0; i<7; i++){
			TestTask task = new TestTask(i);
			pool.submitTask(task);
		}

	}

}
