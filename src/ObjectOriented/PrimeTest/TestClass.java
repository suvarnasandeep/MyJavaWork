package PrimeTest;


import java.util.*;

class TestClass {
	public static void main(String args[] ) throws Exception {

		//print prime number
		/*Scanner in = new Scanner(System.in);
        int var = in.nextInt();
        int count;        
        for(int i=1; i<= var; i++){
            count=0;
            for(int j = i; j>=1; j--){
                if(i%j == 0){
                   count++;
                }
            }
            if(count == 2){
                System.out.print(i + " ");
            }
        }*/

		// print ascii value
		/*Scanner in = new Scanner(System.in);
        String val = in.nextLine();

        int value = (int)val.charAt(0); 
        System.out.println(value);  */  

		//no of divident between 2 no
		/*Scanner in = new Scanner(System.in);
		int minRange = in.nextInt();
		int maxRange = in.nextInt();
		int divisor = in.nextInt();
		int count = 0;
		for(int i = minRange; i<=maxRange; i++){
			if(i%divisor == 0){
				count++;
			}
		}
		System.out.println(count);*/
		
		//factorial
		/*Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int result = 1;
		if(num == 1){
			System.out.println(num);
		} else{
			for(int i = 1; i<= num; i++){
			 result = result * i;	
			}
			System.out.println(result);
		}
		*/
		//photo crop
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int n = in.nextInt();
		String var = in.nextLine();
		int h = Integer.parseInt(var.substring(0, var.indexOf(" ")));
		int w = Integer.parseInt(var.substring(var.indexOf(" ")+1, var.length()));
		
		if(h < l || w < l){
			System.out.println("UPLOAD ANOTHER");
		} else if(h >= l || w >= l){
			if(h == l || w == l){
				System.out.println("ACCEPTED");
			} else{
				System.out.println("CROP IT");
			}
		}
		
	}
}
