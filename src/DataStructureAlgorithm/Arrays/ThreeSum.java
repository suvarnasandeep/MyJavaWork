package DataStructureAlgorithm.Arrays;

import java.util.*;

public class ThreeSum {

    /*
    sum of 3 number results in 0 - return unique triplet summing to 0
    arr = [-1,0,1,2,-1,-4]
    result = [-1,2,-1] [0,-1,1]
    https://www.youtube.com/watch?v=DhFh8Kw7ymk&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=35
     */
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        //List<List<Integer>> res = threeSumBF(arr);
        //List<List<Integer>> res = threeSumBetter(arr);
        List<List<Integer>> res = threeSum(arr);

        for (List<Integer> it : res) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    /*
    int[] arr = {-1,0,1,2,-1,-4};
    O(NlogN)+O(N2)
     */
    private static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            if(i !=0 && arr[i] == arr[i-1])
                continue;
            int j = i+1;
            int k = arr.length-1;
            while (j<k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++;
                } else if (sum > 0){
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    result.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return result;
    }

    //O(n2)
    private static List<List<Integer>> threeSumBetter(int[] arr) {
        Set<List<Integer>> res = new HashSet<>();

        for (int i=0; i<arr.length; i++){
            Set<Integer> set = new HashSet<>();
            for (int j=i+1; j<arr.length; j++){
                int k = -(-arr[i] - arr[j]);
                if(set.contains(k)){
                    List<Integer> tmp = Arrays.asList(arr[i], arr[j], k);
                    tmp.sort(null);
                    res.add(tmp);
                }
                set.add(arr[j]);
            }
        }
        List<List<Integer>> result = new ArrayList<>(res);
        return result;

    }

    //O(n3)
    private static List<List<Integer>> threeSumBF(int[] arr) {
        Set<List<Integer>> res = new HashSet<>();

        for (int i=0; i< arr.length;i++){
            for (int j=i+1; j< arr.length; j++){
                for (int k=j+1; k<arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> tmp = Arrays.asList(arr[i], arr[j], arr[k]);
                        tmp.sort(null);
                        res.add(tmp);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }
}
