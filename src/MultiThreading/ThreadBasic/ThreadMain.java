package ThreadBasic;

public class ThreadMain {

	public static void main(String[] args) {

		/*//Thread stop
		StopThreadDemo obj = new StopThreadDemo();

		Thread t1 = new Thread(obj);
		t1.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj.threadStop();*/

		//Thread join
		Thread t1 = new Thread(new ThreadJoinDemo(), "Thread-1");
		Thread t2 = new Thread(new ThreadJoinDemo(), "Thread-2");
		Thread t3 = new Thread(new ThreadJoinDemo(), "Thread-3");

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("main thread end");
		
		/*//Thread join
		ThreadJoinDemo task1 = new ThreadJoinDemo();
		ThreadJoinDemo task2 = new ThreadJoinDemo();
		ThreadJoinDemo task3 = new ThreadJoinDemo();
		
		Thread t1 = new Thread(task1, "Thread-1");
		Thread t2 = new Thread(task2, "Thread-2");
		Thread t3 = new Thread(task3, "Thread-3");
		
		task3.setPredecessor(t2);
		task2.setPredecessor(t1);	
		
		t1.start();
		t2.start();
		t3.start();
		*/

		//Thread wait notify
		/*ThreadProduce obj = new ThreadProduce();		

		Thread t1 = new Thread(){
			public void run() {
				try {
					obj.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread(){
			public void run() {
				try {
					obj.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();*/


	}

}
