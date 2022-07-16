package ReentrantLock;

public class ResourseMain {

	public static void main(String[] args) {
		
		ProcessResourse obj = new ProcessResourse();
		
		Thread t1 = new Thread(obj, "t1");
		Thread t2 = new Thread(obj, "t2");
		
		t1.start();
		t2.start();
	}

}
