package LeetCode;

import java.util.Arrays;

public class MergeSortedArray {
    /**
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]
    Explanation: The arrays we are merging are [1] and [].
    The result of the merge is [1].

    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
    Output: [1]
    Explanation: The arrays we are merging are [] and [1].
    The result of the merge is [1].
    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
     */

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        mergeArray(nums1, 3, nums2, nums2.length);
        System.out.println();

        int[] nums11 = {1};
        int[] nums21 = {};
        mergeArray(nums11, 1, nums21, 0);
        System.out.println();

        int[] nums111 = {0};
        int[] nums211 = {1};

        mergeArray(nums111, 0, nums211, 1);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int pos = m+n-1;
        int first = m-1;
        int second = n-1;

        while (second >=0){
            if(first >= 0 && nums1[first] > nums2[second]){
                nums1[pos] = nums1[first];
                pos--;
                first--;
            } else {
                nums1[pos] = nums2[second];
                pos--;
                second--;
            }
        }


        Arrays.stream(nums1)
                .forEach(i -> System.out.print(" " + i));
    }

    public static void mergeArray(int[]arr1, int m, int[] arr2, int n){
        int first = m-1;
        int second = n-1;
        int pos = m+n-1;
        while(second >= 0){
            if(first >=0 && arr1[first] >= arr2[second]){
                arr1[pos] = arr1[first];
                pos--;
                first--;
            } else {
                arr1[pos] = arr2[second];
                pos--;
                second--;
            }
        }

        Arrays.stream(arr1).forEach(i -> System.out.print(" " + i));
    }
}
