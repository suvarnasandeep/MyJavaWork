package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    /**
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [-1,3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
     * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     */

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};

        int[] res = nextGreaterElement(nums1, nums2);
        for (int i : res)
            System.out.print(i + " ");

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[nums2.length];
        int[] res = new int[nums1.length];

       /* for (int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }*/

        int len = nums2.length;
        for (int i=len-1; i>=0; i--){
            map.put(nums2[i], i);
            while (!s.isEmpty() && nums2[i] >= s.peek()){
                s.pop();
            }
            if (!s.isEmpty()){
                arr[i] = s.peek();
            } else {
                arr[i] = -1;
            }
            s.push(nums2[i]);
        }

        for (int i=0; i<nums1.length; i++){
            res[i] = arr[map.get(nums1[i])];
        }
        return res;
    }
}
