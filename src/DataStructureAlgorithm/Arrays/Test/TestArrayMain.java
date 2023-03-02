package DataStructureAlgorithm.Arrays.Test;

import DataStructureAlgorithm.Arrays.ArraysMain;
import DataStructureAlgorithm.Arrays.RotatedArray;

public class TestArrayMain {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        rotateByN(arr, 9);

        int[]arr1 = {3,4,5,6,1,2};
        ArraysMain.printInputArray(arr1);
        findNinRotatedArray(arr1, 2);

    }
    public static void findNinRotatedArray(int[] arr, int n){
        int pivot = findPivot(arr);
        if(pivot == -1){
            System.out.println("index : " + binarySearch(arr,0,arr.length-1, n));
        } else if(arr[0] < n){
            System.out.println("index : " + binarySearch(arr, 0 , pivot, n));
        } else {
            System.out.println("index : " + binarySearch(arr, pivot+1 ,arr.length-1 , n));
        }

    }

    private static int binarySearch(int[] arr, int start, int end, int n) {
        if(start > end)
            return -1;
        int mid = (start+end)/2;
        if(arr[mid] == n)
            return mid;

        if(arr[mid] > n){
           return binarySearch(arr, 0,mid-1, n);
        } else {
           return binarySearch(arr, mid+1, end,n);
        }
    }

    private static int findPivot(int[] arr) {
        for (int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return i;
            }
        }
        return -1;
    }

    private static void rotateByN(int[] arr, int i) {
        i = i%arr.length;
        RotatedArray.printArray(arr);
        reverseArr(arr, 0, i-1);
        reverseArr(arr,i,arr.length-1);
        reverseArr(arr, 0, arr.length-1);
        RotatedArray.printArray(arr);
    }

    private static void reverseArr(int[] arr, int i, int i1) {
        int tmp;
        while (i < i1){
            tmp = arr[i];
            arr[i] = arr[i1];
            arr[i1] = tmp;
            i++;
            i1--;
        }
    }


}
