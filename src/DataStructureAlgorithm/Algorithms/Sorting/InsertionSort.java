package Sorting;

public class InsertionSort {
    /**
     * Worst Time Complexity :- O(n2)
     *      -an array is in ascending order, and you want to sort it in descending order.
     * Best Time Complexity :- O(n)
     *      -When the array is already sorted.
     **/
    public static void doInsertionSort(int[] input){
        int n = input.length;

        for(int i = 1; i < n; i++){
            int key = input[i];
            int j = i-1;
            while(j>=0 && key < input[j]){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = key;

        }
    }

}
