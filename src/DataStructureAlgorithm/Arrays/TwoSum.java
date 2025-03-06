package DataStructureAlgorithm.Arrays;

import java.util.*;

/*
Given int array and target, return index of two number such that they add upto target value

Ex: 2,7,11,15  target - 9
    2+7=9
    return {0,1}
 */
public class TwoSum {

    //O(n2)
    public List getTwoSum(int[] arr, int target){
        List<Integer> list = new ArrayList<>();

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

    public static void main(String[] args) {
        int[] input = {16,8,23,4,15};
        //int[] input = {2,7,11,15};
        int target = 19;

        Utils.printArray(input);
        TwoSum obj = new TwoSum();
        System.out.println(obj.getTwoSum(input, target));
        System.out.println(obj.getTwoSumHash(input, target));

        System.out.println(getTwoSUmTest(input, target));
        System.out.println(getTwoSUmTest1(input, target));
    }

    //***********************************************
    private static List getTwoSUmTest1(int[] input, int target) {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i=0; i<input.length; i++){
        int val = target - input[i];
        if(map.containsKey(val)){
            list.add(map.get(val));
            list.add(i);
        } else {
            map.put(input[i],i);
        }
    }

    return list;
    }

    public static List getTwoSUmTest(int[] arr, int target){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
               if(arr[i] == target-arr[j]){
                   list.add(i);
                   list.add(j);
                   break;
               }
            }
        }
        return list;
    }
}
