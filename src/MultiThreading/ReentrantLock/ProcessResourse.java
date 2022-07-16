package ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessResourse implements Runnable{

	int count = 0;
	Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		
		while(getCount() <= 6){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public int getCount() {
		try{
		lock.lock();
		
		System.out.println(Thread.currentThread().getName() +" gets count " + count);
		return count++;
		
		} finally {
			lock.unlock();
		}
	}

}
