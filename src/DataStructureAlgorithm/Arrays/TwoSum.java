package DataStructureAlgorithm.Arrays;

import java.util.*;

/*
Given int array and target, return index of two number such that they add upto target value

Ex: 2,7,11,15  target - 9
    2+7=9
    return {0,1}
 */
public class TwoSum {

    public List getTwoSum(int[] arr, int target){
        List<Integer> list = new ArrayList<>();

       // Arrays.sort(arr);

        for(int j=0; j<arr.length; j++ ){
            for(int k=j+1; k<arr.length; k++){
                if(arr[j] == target-arr[k]){
                    list.add(j);
                    list.add(k);
                    break;
                }
            }
        }
        return list;
    }

    //O(n)
    public List getTwoSumHash(int[] arr, int target){
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int j=0; j<arr.length; j++ ){
            int toFind = target - arr[j];
            if(map.containsKey(toFind)){
                list.add(map.get(toFind));
                list.add(j);
            } else {
                map.put(arr[j], j);
            }
        }
        return list;
    }
}
