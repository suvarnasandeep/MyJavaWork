package Arrays;

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
}
