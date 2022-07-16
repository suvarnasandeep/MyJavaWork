package Arrays;

import java.util.*;

public class MissingNumber {

    public List<Integer> getMissingNumbers(int[] arr1, int[] arr2){
        printInputArray(arr1,arr2);
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i : arr1){
            int var =  map.getOrDefault(i,0);
            var++;
            map.put(i, var);
        }

        for(int j : arr2){
            int var = map.get(j);
            var--;
            if(var==0){
                map.remove(j);
            } else {
                map.put(j, var);
            }
        }

        for(Integer val : map.keySet()){
            if(map.get(val) !=0){
                list.add(val);
            }
        }

        return list;
    }

    private void printInputArray(int[] arr1, int[] arr2) {
        System.out.println("------------------------");
        System.out.print("[ ");
        for(int i : arr1)
            System.out.print(i + " ");

        System.out.println("]");
        System.out.print("[ ");
        for(int i : arr2)
            System.out.print(i + " ");

        System.out.println("]");
    }
}
