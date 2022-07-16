package volatiletest;

public class VolatileDemo {
	
	private static volatile boolean flag = false;
	

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i=1;
				while(i !=10000) {
					System.out.println(i);
					i++;
				}
				flag = true;
				System.out.println("flag changed to " + flag);
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i=1;
				while(!flag) {
					i++;
				}
				System.out.println("start other process " + i);
				
			}
		}).start();

	}

}
