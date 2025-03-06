package DataStructureAlgorithm.Arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMaxValue {

    public int getNumberOfMAxValue(int[] arr){
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i : arr){
            if(i > max)
                max = i;
            int count = map.getOrDefault(i, 0);
            map.put(i, ++count);
        }


        return map.get(max);

    }

    public static void main(String[] args) {
        int[] input = {3,4,1,5,1,5,4};
        Utils.printArray(input);

        NumberOfMaxValue m = new NumberOfMaxValue();
        System.out.println("Number of max val : " + m.getNumberOfMAxValue(input));

    }
}
