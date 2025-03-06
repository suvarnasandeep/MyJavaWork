package BinarySearchTree.UniqueBST;

import java.util.Arrays;
import java.util.Scanner;

public class NoOfUniqueBSTMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		System.out.println("input = " + i);
		
		System.out.println("No of unique BST = " + noOfUniqueBST(i));

	}
	
	public static int noOfUniqueBST(int n){
		int arr[] = new int[n+1];
		Arrays.fill(arr, 0);
		
		arr[0] = 1;
		arr[1] = 1;
		
		// i-1 left n-i right
		for(int i = 2; i <= n; i++){
			for(int j = 1; j <= i; j++){
				arr[i] = arr[i] + (arr[j-1] * arr[i-j]);
			}
		}
		
		return arr[n];
	}

}
