package AutomicOperation;


public class AutomicMain {

	public static void main(String[] args) {
		IncrementShared obj1 = new IncrementShared();
		
		Thread t1 = new Thread(obj1, "t1");
		
		Thread t2 = new Thread(obj1, "t2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("count == "+obj1.getCount());
		

	}

}
