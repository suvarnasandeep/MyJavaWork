package DataStructureAlgorithm.Arrays;

import java.util.*;

public class UnionOfTwoSortedArray {
    /*
    input
        arr1 = [1,1,2,4,5,6,]
        arr2 = [1,3,4,7]
    output
        output = [1,2,3,4,5,6,7]
     */
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,4,5,6};
        int[] arr2 = {1,3,4,7};

        int[] res = union(arr1,arr2);
        Utils.printArray(res);
    }

    public static int[] unionBF(int[] arr1, int[] arr2){
        Set<Integer> set = new TreeSet<>();
        for (int i: arr1){
            set.add(i);
        }
        for (int i: arr2){
            set.add(i);
        }

        int[] res = new int[set.size()];
        int j=0;
        for (int i:set)
            res[j++] = i;

        return res;
    }

    public static int[] union(int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        int l1 = arr1.length;
        int l2 = arr2.length;
        int i=0;int j=0;

        while (i<l1 && j<l2){
            if(arr1[i] <= arr2[j]){
                if(!list.contains(arr1[i])){
                    list.add(arr1[i]);
                }
                i++;
            } else {
                if(!list.contains(arr2[j])){
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        while (i<l1){
            if(!list.contains(arr1[i]))
                list.add(arr1[i]);
            i++;
        }
        while (j<l2){
            if (!list.contains(arr2[j]))
                list.add(arr2[j]);
            j++;
        }

        int[] res = new int[list.size()];
        for (int k=0; k<list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
    }
}
