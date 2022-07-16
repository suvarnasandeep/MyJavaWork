package ThreadJoin;

import java.io.IOException;

public class ThreadJoin {

	public static void main(String[] args){

		Thread t1 =new Thread(){
			public void run(){

				System.out.println("inside T1-run");

				for(int i = 0; i<=10; i++){
					try {
						sleep(500);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
					System.out.print(i + " ");
				}
			}
		};

		Thread t2 =new Thread(){
			public void run(){
				try {
					t1.join();
					System.out.println("inside T2-run");

					for(int i = 11; i<=20; i++){

						sleep(500);

						System.out.print(i + " ");
					}
				}
				catch (InterruptedException e) {						
					e.printStackTrace();
				}
			}
		};

		Thread t3 =new Thread(){
			public void run(){
				try {
					t2.join();
					System.out.println("inside T3-run");

					for(int i = 21; i<=30; i++){

						sleep(500);

						System.out.print(i + " ");
					}
				} catch (InterruptedException e) {						
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
		t3.start();

		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*ThreadInterferance s1 = new ThreadInterferance();
		
		Thread thread1 = new Thread(){
			public void run() {
				s1.sharedMethod();
			}
		};
		
		Thread thread2 = new Thread(){
			public void run() {
				s1.sharedMethod();
			}
		};
		
		thread1.start();
		thread2.start();
		
		Thread intThread = new Thread(new ThreadIntrrupt(), "Thread-1");
		intThread.start();
		
		System.out.println("press enter");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		intThread.interrupt();
		*/
		System.out.println("main end");
	}
}

