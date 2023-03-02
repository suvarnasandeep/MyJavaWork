package MultiThreading.PrintEvenAndOdd;

public class PrintNumber{

	private boolean flag = false;

	public void printOdd(int num) {
		synchronized (this) {
			for(int i = 1; i<= num; i = i+2){
				while(flag){
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(i + "->");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = true;
				notify();
			}
		}
	}

	public void printEven(int num) {
		synchronized (this) {
			for(int i = 2; i<= num; i = i+2){
				while(!flag){
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(i + "->");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = false;
				notify();
			}
		}
	}
}
