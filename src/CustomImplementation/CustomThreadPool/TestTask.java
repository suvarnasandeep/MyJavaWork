package CustomThreadPool;

public class TestTask implements Runnable{

	private int number;

	public TestTask(int num) {
		this.number = num;
	}

	public void run(){
		System.out.println("executing test task :"+number);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//System.out.println("end executing test task :"+number);
	}
}
