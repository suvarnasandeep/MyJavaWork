package DataStructureAlgorithm.Arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArray {
    /*
    input
        arr1 = [1,2,2,3,3,4,5,6]
        arr2 = [2,3,3,5,6,6,7]
    output
        out = [2,3,3,5,6]
     */
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,3,4,5,6};
        int[] arr2 = {2,3,3,5,6,6,7};

        int[] res = intersection(arr1,arr2);
        Utils.printArray(res);
    }

    private static int[] intersection(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i=0; int j=0;
        List<Integer> list = new ArrayList<>();

        while (i<len1 && j<len2){
            if(arr1[i] == arr2[j]){
                list.add(arr1[i]);
                i++;
                j++;
            } else if(arr1[i] < arr2[j]){
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[list.size()];
        for (int k=0; k<list.size(); k++)
            res[k] = list.get(k);

        return res;
    }
}
