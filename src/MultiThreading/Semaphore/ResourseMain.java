package Semaphore;

public class ResourseMain {

	public static void main(String[] args) {
		
		ProcessResourse obj = new ProcessResourse();
		
		Thread t1 = new Thread(obj, "t1");
		Thread t2 = new Thread(obj, "t2");
		Thread t3 = new Thread(obj, "t3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
