package ThreadDeadlock;


public class DeadlockDemo {
	public synchronized void method1( DeadlockDemo obj) {
		System.out.println("inside method1");
		obj.method2(this);
		System.out.println("end of method1");
	}
	
	public synchronized void method2(DeadlockDemo obj) {
		System.out.println("inside method2");
		obj.method1(this);
		System.out.println("end of method2");
	}
}
