package Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessResourse implements Runnable{

	Semaphore sem = new Semaphore(2);
	
	@Override
	public void run() {
		
		getCount();
		
	}

	public void getCount() {
		
		try {
			sem.acquire();
			
			System.out.println(Thread.currentThread().getName() + " aquired lock");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " released lock");
		sem.release();
	}

}
