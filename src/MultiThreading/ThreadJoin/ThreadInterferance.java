package ThreadJoin;

public class ThreadInterferance {
	int i;
	
	public void sharedMethod() {
		i = 10;
		System.out.println(i);
		i = 20;
		System.out.println(i);
		i = 30;
		System.out.println(i);
	}
}
