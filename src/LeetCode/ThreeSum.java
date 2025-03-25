package LeetCode;

import java.util.*;

public class ThreeSum {
    /**
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     */

    public static void main(String[] args) {
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i =0; i<n; i++){
            if(i !=0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1])
                        j++;
                    while (j<k && nums[k] == nums[k+1])
                        k--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumBF(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int len = nums.length;
        for (int i=0; i<len; i++){
            for (int j=i+1; j<len; j++){
                for (int k=j+1; k<len; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> tmp =  Arrays.asList(nums[i], nums[j], nums[k]);
                        tmp.sort(null);
                        res.add(tmp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }
}
