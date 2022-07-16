package DataStructureAlgorithm.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Given an array, determine the minimum loss
 */
public class MinimumLoss {

    public int getMinLossBF(int[] arr){
        int res = 9999;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    int dif = arr[i] - arr[j];
                    if(res > dif){
                        res = dif;
                    }
                }
            }
        }
        return  res;
    }

    public int getMinLoss(int[] input) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<input.length; i++){
            map.put(input[i], i);
        }

        Arrays.sort(input);

        for(int j= input.length-1; j>0; j--){
            if(map.get(input[j]) > map.get(input[j-1])){
                continue;
            }

            int val = input[j] - input[j-1];
            min = Math.min(val,min);
        }
        return min;
    }
}
