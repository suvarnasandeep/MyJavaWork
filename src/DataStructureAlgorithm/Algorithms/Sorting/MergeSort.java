package DataStructureAlgorithm.Algorithms.Sorting;

import java.util.ArrayList;

public class MergeSort {
    /**
     * Time Complexity :- O(n log(n))
     *
     * 	Space Complexity :- O(n)
     *
     * 	https://www.youtube.com/watch?v=-qjc4fYsZTU&list=PLFdAYMIVJQHNJnCK8XopkeyaZqneVZzrO&index=4
     **/

    public static void mergeSort(int[] arr, int low, int high){
        if(low >= high)
            return;
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        mergeArr(arr, low, mid, high);
    }

    private static void mergeArr(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while (left <= mid && right <= high){
            if(arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }
        while (left <= mid){
            list.add(arr[left]);
            left++;
        }
        while (right <= high){
            list.add(arr[right]);
            right++;
        }
        for (int i=low; i<= high; i++){
            arr[i] = list.get(i-low);
        }
    }

    /*
    Alternative approach
     */
    public static void doMergeSort(int[] arr){
        int numOfEle = arr.length;        
        if(numOfEle == 1){
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

    public static void main(String[] args) {
        int[] input = new int[]{25, 2, 9, 50, 8, 1};
        printInput(input);
        //MergeSort.doMergeSort(input);
        //mergeSort(input, 0, input.length-1);
        test(input, 0, input.length-1);
        printInput(input);
    }

    private static void test(int[] arr, int low, int high) {
        if(low >= high)
            return;
        int mid = (low+high)/2;
        test(arr,low, mid);
        test(arr, mid+1,high);
        mergetest(arr, low, mid, high);

    }

    private static void mergetest(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        ArrayList<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }
        while (left<= mid){
            list.add(arr[left]);
            left++;
        }
        while (right<=high){
            list.add(arr[right]);
            right++;
        }
        for (int i=low; i<=high; i++){
            arr[i] = list.get(i-low);
        }
    }

    public static  void printInput(int[] input){
        for(int i : input){
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
