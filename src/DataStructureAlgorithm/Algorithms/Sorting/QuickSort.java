package Sorting;

public class QuickSort {
    /**
     *  Time Complexity :- O(n log n)
     *
     * 	Space Complexity :- O(log n)
     *
     * 	https://www.youtube.com/watch?v=2SRzQEOaLYw&list=PLFdAYMIVJQHNJnCK8XopkeyaZqneVZzrO&index=5
     * 	https://studyalgorithms.com/array/quick-sort/
     **/
    public static void doQuickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end){
            int partition = findPartition(arr, start, end);
            quickSort(arr, start, partition-1);

            quickSort(arr, partition+1, end);
        }
    }

    private static int findPartition(int[] arr, int start, int end) {
        //taking last element as pivot
        int pivot = arr[end];

        int i = start-1;

        for(int j=start; j<end; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i,j);
            }
        }
        swap(arr, i+1, end);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
