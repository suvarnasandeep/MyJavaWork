package DataStructureAlgorithm.Arrays;

import jdk.jshell.execution.Util;

public class RotatedArray {
	/*
	 *Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements left direction.
	 *Time complexity : O(n * d)  
	 *Auxiliary Space : O(1)
	 */
	//Method 1
	public static void rotateArrayLeftBF(int[] arr, int d){
		int[] tmp = new int[d];
		int n = arr.length;
		System.out.println("--------------------");
		Utils.printArray(arr);

		for(int i=0; i<d; i++){
			tmp[i] = arr[i];
		}

		for(int j=0; j<n-d; j++){
			arr[j] = arr[j+d];
		}

		for(int k = n-d, l=0; k<n; k++, l++){
			arr[k] = tmp[l];
		}
		Utils.printArray(arr);
		System.out.println("--------------------");
	}

	/*
	 Time Complexity : O(n)
	 */
	public static void rotateArrayLeft(int[]arr, int d) {
		Utils.printArray(arr);
		int n = arr.length;
		if(d==0)
			return;
		
		d= d%n;
		/* d=3
		1 2 3 4 5 6 7
		3 2 1 4 5 6 7		-reverse first k  number
		3 2 1 7 6 5 4		-reverse last k number
		4 5 6 7 1 2 3		-reverse all number
		 */
		reverseArr(arr, 0, d-1);
		reverseArr(arr, d, n-1);
		reverseArr(arr, 0, n-1);
		
		Utils.printArray(arr);

		/* second approach
		d=3
		1 2 3 4 5 6 7
		7 6 5 4 3 2 1 		-reverse all number
		4 5 6 7 3 2 1		-reverse first k  number
		4 5 6 7 1 2 3		-reverse last k number
		 */
//		System.out.println("------------------");
//		reverseArr(arr, 0,n-1);		//reverse all number
//		reverseArr(arr, 0,n-d-1);	//reverse first (length - k ) number
//		reverseArr(arr, n-d, n-1);	//reverse last k number
//		printArray(arr);
//		System.out.println("------------------");
	}

	/*
	Given an array, cyclically rotate the array clockwise by d
	Input:  arr[] = {1, 2, 3, 4, 5}
	d=1
	Output: arr[] = {5, 1, 2, 3, 4}
	d=3
	Output: arr[] = {3, 4, 5, 1, 2}

	 */
	public static void rotateArrayRight(int[] arr, int d){
		int n = arr.length;
		Utils.printArray(arr);
		if(d==0)
			return;

		d = d%n;
		d= Math.abs(n-d);

		reverseArr(arr, 0, d-1);
		reverseArr(arr, d, n-1);
		reverseArr(arr, 0,n-1);


		Utils.printArray(arr);

	}
	
	private static void reverseArr(int[] arr, int start, int end) {
		int tmp;
		while(start < end) {
			tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[]arr = {1,2,3,4,5,6};

		//RotatedArray.rotateArrayLeftBF(arr, 2);
		//RotatedArray.rotateArrayLeft(arr, 2);
		//System.out.println("------------------");
		//RotatedArray.rotateArrayRight(arr, 7);

		//test(arr, 2);
		testleft(arr,3);
	}
	//*******************Test********************
	public static void test(int[] arr, int d){
		Utils.printArray(arr);
		int[] tmp = new int[d];
		for(int i=0; i<d; i++){
			tmp[i] = arr[i];
		}
		for (int j =0; j<arr.length-d; j++){
			arr[j] = arr[j + d];
		}
		for (int k= arr.length -d, l = 0; k< arr.length; k++, l++){
			arr[k] = tmp[l];
		}
		Utils.printArray(arr);
	}

	public static void testleft(int[] arr, int d){
		Utils.printArray(arr);
		if(d == 0){
			return;
		}

		int n = d% arr.length;
		reverse(arr, 0, n-1);
		reverse(arr, n, arr.length-1);
		reverse(arr, 0, arr.length-1);
		Utils.printArray(arr);
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end){
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

}
