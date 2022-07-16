package ThreadBasic;
import java.util.Scanner;

public class ThreadProduce {

	public void produce() throws InterruptedException {
		          
            synchronized(this)
            {
                System.out.println("producer thread running");               
                wait();               
                System.out.println("Resumed");
            }
	}
	
	public void consume () throws InterruptedException {
		Thread.sleep(1000);
        Scanner s = new Scanner(System.in);

        synchronized(this)
        {
            System.out.println("Waiting for return key.");
            s.nextLine();
            System.out.println("Return key pressed");

            notify();

            // Sleep
            Thread.sleep(2000);
	}
}
}
