package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MajorityElementArray {
    /*
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:
    Input: nums = [3,2,3]
    Output: 3

    Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2
     */
    public static void main(String[] args) {
        //int[] input = {3,2,3};
        int[] input = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(input));
    }

    public static int majorityElement(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int max = 0;

        for (int i : arr){
            map.put(i, 1 + map.getOrDefault(i,0));

            if(map.get(i) > max){
                res = i;
                max = map.get(i);
            }
        }

        return res;
    }
}
