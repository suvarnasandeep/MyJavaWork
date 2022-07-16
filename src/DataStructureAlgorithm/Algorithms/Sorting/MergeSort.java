package Sorting;

public class MergeSort {
    /**
     * Time Complexity :- O(n log(n))
     *
     * 	Space Complexity :- O(n)
     *
     * 	https://www.youtube.com/watch?v=-qjc4fYsZTU&list=PLFdAYMIVJQHNJnCK8XopkeyaZqneVZzrO&index=4
     **/
    public static void doMergeSort(int[] arr){
        int numOfEle = arr.length;        
        if(numOfEle <2){
            return;
        }
        
        int mid = numOfEle/2;
        int[] leftArr = new  int[mid];
        int[] rightArr = new int[numOfEle-mid];
        
        for(int i = 0; i < mid; i++){
            leftArr[i] = arr[i];
        }
        
        for(int j=mid; j<numOfEle; j++){
            rightArr[j-mid] = arr[j];
        }
        
        doMergeSort(leftArr);
        doMergeSort(rightArr);
        
        merge(arr, leftArr, rightArr, mid, numOfEle-mid);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i=0, j=0, k=0;

        while(i < left && j < right){
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < left){
            arr[k++] = leftArr[i++];
        }
        while (j < right){
            arr[k++] = rightArr[j++];
        }
    }
}
