package PrintEvenAndOdd;

public class TestPrintNum {

	public static void main(String[] args){
		
		PrintNumber obj = new PrintNumber();
		int num =10;
		
		Thread t1 = new Thread(){
			public void run(){
				obj.printOdd(num);
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				obj.printEven(num);
			}
		};
		
		t1.start();
		t2.start();
	}
}
