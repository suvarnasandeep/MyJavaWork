package DataStructureAlgorithm.Arrays;

public class RotatedArray {
	
	/*
	 *Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
	 *Time complexity : O(n * d)  
	 *Auxiliary Space : O(1)
	 */
	//Brute force
	public void rotateByN(int[]arr, int n, int d) {
		printArray(arr);		
		for(int i=0; i<d;i++) {
			int var = arr[0];
			for(int j=0;j<arr.length-1;j++) {				
				arr[j] = arr[j+1];				
			}
			arr[arr.length-1] = var;			
		}
		
		printArray(arr);
	}

	//Method 1
	public void rotateMethod1(int[] arr, int n, int d){
		int[] tmp = new int[d];
		System.out.println("--------------------");
		printArray(arr);

		for(int i=0; i<d; i++){
			tmp[i] = arr[i];
		}

		for(int j=0; j<n-d; j++){
			arr[j] = arr[j+d];
		}

		for(int k = n-d, l=0; k<n; k++, l++){
			arr[k] = tmp[l];
		}
		printArray(arr);
		System.out.println("--------------------");
	}

	/*
	 Time Complexity : O(n)
	 */
	public void rotateByN_One(int[]arr, int n, int d) {
		printArray(arr);
		if(d==0)
			return;
		
		d= d%n;
		/* d=3
		1 2 3 4 5 6 7
		3 2 1 4 5 6 7
		3 2 1 7 6 5 4
		4 5 6 7 1 2 3
		 */
		reverseArr(arr, 0, d-1);		//reverse first k  number
		reverseArr(arr, d, n-1);			//reverse last k number
		reverseArr(arr, 0, n-1);		//reverse all number
		
		printArray(arr);

		System.out.println("------------------");
		reverseArr(arr, 0,n-1);		//reverse all number
		reverseArr(arr, 0,n-d-1);	//reverse first (length - k ) number
		reverseArr(arr, n-d, n-1);	//reverse last k number
		printArray(arr);
		System.out.println("------------------");

	}
	
	private void reverseArr(int []arr, int start, int end) {
		
		int tmp;
		while(start < end) {
			tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
		
	}

	public void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	

}
