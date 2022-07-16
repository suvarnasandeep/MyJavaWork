package ThreadDeadlock;


public class DeadlockMain {

	public static void main(String[] args) {
		
		DeadlockDemo obj1 = new DeadlockDemo();
		DeadlockDemo obj2 = new DeadlockDemo();
		
		System.out.println("main method start");
		Thread t1 = new Thread(){
			public void run(){
				obj1.method1(obj2);
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				obj2.method2(obj1);
			}
		};
		
		t1.start();
		t2.start();
		
		
		System.out.println("main method end");
	}

}
