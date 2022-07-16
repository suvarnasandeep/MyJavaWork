package DataStructureAlgorithm.Algorithms.Sorting;

public class SelectionSort {

	/**
	 * Worst Time Complexity :- O(n2)
	 * 		-Array is in descending  order, and you want to sort it in ascending order.
	 * 	Best Time Complexity :- O(n2)
	 * 	    -When the array is already sorted.
     **/
	public static void doSelectionSort(int[] input){

		for(int i=0; i < input.length; i++){
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

	public static void doSelectionSortTest(int[] arr){
		for(int i=0; i<arr.length; i++){
			int min = i;
			 for(int j = i+1; j<arr.length; j++){
			 	if(arr[j] <= arr[min]){
			 		min = j;
				}
			 }

			 if(min != i){
			 	int tmp = arr[i];
			 	arr[i] = arr[min];
			 	arr[min] = tmp;
			 }
		}
	}


}
