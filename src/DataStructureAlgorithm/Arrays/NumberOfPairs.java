package DataStructureAlgorithm.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Detemine number of pairs that hve a difference equals to target value

Ex : 1 2 3 4   target value = 1
    2-1 = 1
    3-2 = 1
    4-3 = 1
    Ans = 3

    1 5 3 4 2  target value = 2
    5-3 = 2
    4-2 = 2
    3-1 = 2
    Ans = 3
 */
public class NumberOfPairs {

    public int getNumberOfPairs(int[] input, int target){
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:input){
            int occ = map.getOrDefault(i,0);
            map.put(i, ++occ);
        }

        for(int i=0; i<=input.length-1; i++){
            //if(input[i] > target){
                int v = map.getOrDefault((input[i] - target),0);
                if(v != 0){
                    res += v;
                }
            //}
        }
        return res;
    }

    public  int getNumberOfPairsBF(int[] input, int target){
        Utils.printArray(input);
        int res = 0;
        Arrays.sort(input);

        for(int i=0; i<=input.length-1; i++) {
            for (int j = input.length - 1; j >= 0; j--) {
                if (input[i] - input[j] == target) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2};
        NumberOfPairs n = new NumberOfPairs();
        int target = 1;
        System.out.println("Number of pairs : " + n.getNumberOfPairs(arr, target));
        System.out.println("Number of pairs : " + n.getNumberOfPairsBF(arr, target));

    }
}
