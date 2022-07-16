package PrintEvenAndOdd.ThreadEvenOddPrint;

public class ThreadEvenOddPrint {

	public void printOdd() {

		synchronized (this) {
			while(ThreadEvenOddMain.count < ThreadEvenOddMain.MAX){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {					
					e1.printStackTrace();
				}
				if(!ThreadEvenOddMain.flag){				
					try {
						wait();
					} catch (InterruptedException e) {					
						e.printStackTrace();
					}
				}

				
				System.out.println(Thread.currentThread() + "->"  + ThreadEvenOddMain.count );
				ThreadEvenOddMain.count++;
				ThreadEvenOddMain.flag = false;
				notify();
			}
		}

	}

	public void printEen() {

		synchronized (this) {
			while(ThreadEvenOddMain.count < ThreadEvenOddMain.MAX){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {					
					e1.printStackTrace();
				}
				if(ThreadEvenOddMain.flag){
					try {
						wait();
					} catch (InterruptedException e) {					
						e.printStackTrace();
					}
				}

				
				System.out.println(Thread.currentThread() + "->"  + ThreadEvenOddMain.count);
				ThreadEvenOddMain.count++;
				ThreadEvenOddMain.flag = true;
				notify();
			}
		}
	}

}
