package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,};
        int[] res = twoSum1(arr, 6);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    list.add(i);
                    list.add(j);
                }
            }
        }
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    public static int[] twoSum1(int[] nums, int target){
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            if(map.containsKey(target-num)){
                list.add(i+1);
                list.add(map.get(target-num)+1);
            } else {
                map.put(nums[i], i);
            }
        }

        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}
