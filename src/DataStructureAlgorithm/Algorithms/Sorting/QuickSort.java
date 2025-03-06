package DataStructureAlgorithm.Algorithms.Sorting;

public class QuickSort {
    /**
     *  Time Complexity :- O(n log n)
     *
     * 	Space Complexity :- O(log n)
     *
     * https://www.youtube.com/watch?v=WIrA4YexLRQ&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=15
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

    public static void main(String[] args) {
        int[] input = new int[]{25, 2, 9, 50, 8, 1};
        printInput(input);
        //QuickSort.doQuickSort(input);
        //test(input, 0, input.length-1);
        quickSortTest(input, 0, input.length-1);
        printInput(input);
    }
    public static  void printInput(int[] input){
        for(int i : input){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //*********************Test*********************//
    private static void test(int[] input, int low, int high) {
        if(low < high){
            int partition = partition(input, low, high);
            test(input, low, partition-1);
            test(input, partition+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;

        for (int j =low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }

    private static void quickSortTest(int[] arr, int l, int h){
        if(l < h){
            int partition = getPartition(arr, l, h);
            quickSortTest(arr, l, partition-1 );
            quickSortTest(arr, partition+1, h);
        }
    }

    private static int getPartition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l-1;

        for(int j=l; j<h; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i,h);
        return i;
    }
}
