package PrintEvenAndOdd.ThreadEvenOddPrint;

public class ThreadEvenOddMain {

	public static int count = 1;
	public static int MAX = 20;
	public static boolean flag;
	
	public static void main(String[] args) {
		
		ThreadEvenOddPrint obj = new ThreadEvenOddPrint();
		flag = true;
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				obj.printOdd();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				obj.printEen();
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		

		
	}

}
