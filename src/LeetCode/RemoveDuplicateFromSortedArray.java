package LeetCode;

public class RemoveDuplicateFromSortedArray {
    /**
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element
    appears at most twice. The relative order of the elements should be kept the same.

    Example 1:
    Input: nums = [1,1,1,2,2,3]
    Output: 5, nums = [1,1,2,2,3,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
     */

    public static void main(String[] args) {
        int [] arr = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }

    private static int removeDuplicates(int[] arr) {
        int k =2;
        for (int i =2; i<arr.length; i++){
            if(arr[i] != arr[k-2]){
                arr[k] = arr[i];
                k++;
            }
        }

        return k;
    }
}
