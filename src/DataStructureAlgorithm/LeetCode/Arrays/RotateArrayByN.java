package DataStructureAlgorithm.LeetCode.Arrays;

import DataStructureAlgorithm.LeetCode.Utils;

public class RotateArrayByN {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 8);
    }

    public static void rotate(int[] arr, int n){

        int len = arr.length-1;
        Utils.printarray(arr);
        if(n==0)
            return;

        n=n% arr.length;
        reverse(arr, 0, n-1);
        reverse(arr, n , len);
        reverse(arr, 0, len);
        Utils.printarray(arr);
    }



    private static void reverse(int[]arr, int start, int end) {
        int tmp;
        while(start < end){
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
