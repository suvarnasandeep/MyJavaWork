package DataStructureAlgorithm.Arrays;

import java.util.*;

public class DuplicatesInArray {

    //O(n)
    public static List getDuplicates(int[] arr){
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
    public static List getDuplicates1(int[] arr){
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

    /*
    O(N)
     */
    public static Set<Integer> removeDuplicates(int[] arr){
        Set<Integer> set = new LinkedHashSet<>();
        for (int a : arr){
            set.add(a);
        }
        return set;
    }
    public static void main(String[] args) {
        int[] input = {4,3,2,8,2,3,1,7};
        //int[] input = {2,7,11,15};

        Utils.printArray(input);
        //System.out.println("Duplicate vale : "+ getDuplicates(input));
        //System.out.println("Duplicate vale : "+ getDuplicates1(input));
        System.out.println(removeDuplicates(input));
    }
}
