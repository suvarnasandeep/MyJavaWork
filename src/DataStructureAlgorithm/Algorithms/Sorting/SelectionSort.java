package DataStructureAlgorithm.Algorithms.Sorting;

public class SelectionSort {

	/**
	 * Worst Time Complexity :- O(n2)
	 * 		-Array is in descending  order, and you want to sort it in ascending order.
	 * 	Best Time Complexity :- O(n2)
	 * 	    -When the array is already sorted.
     **/
	public static void doSelectionSort(int[] input){
		for(int i=0; i < input.length - 1; i++){
			int min = i;
			for(int j = i+1; j <input.length; j++){
				if(input[j] < input[min]){
					min = j;
				}
			}
			if(min != i) {
				int tmp = input[i];
				input[i] = input[min];
				input[min] = tmp;
			}
		}
	}

	public static void main(String[] args) {
			int[] input = new int[]{25, 2, 9, 3, 50, 8, 1};
			printInput(input);
			SelectionSort.doSelectionSort(input);
			//test(input);
			printInput(input);
	}
	public static  void printInput(int[] input){
		for(int i : input){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void test(int[]arr){
		for (int i=0; i< arr.length-1; i++){
			int min = i;
			for (int j = i+1; j<arr.length; j++){
				if(arr[j] <= arr[min]){
					min = j;
				}
			}
			if(i != min){
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
	}
}
