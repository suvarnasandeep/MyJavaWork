package DataStructureAlgorithm.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesInArray {

    //O(n)
    public List getDuplicates(int[] arr){
        List<Integer> list= new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int a : arr){
            int count = map.getOrDefault(a,0);
            if(count != 0){
                list.add(a);
            } else {
                map.put(a,++count);
            }
        }
        return list;
    }

    // 1<= num[i] <= n
    public List getDuplicates1(int[] arr){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<=arr.length-1; i++){
            int num = Math.abs(arr[i]);
            int index = num -1;
            if(arr[index] < 0 ){
                list.add(arr[i]);
            } else {
                arr[index] = arr[index] * -1;
            }
        }
        return list;
    }
}
