package DataStructureAlgorithm.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonRepeatingElement {

    //O(n)
    public List getNonRepeatingElement(int[] arr){
        List list = new ArrayList();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<=arr.length-1; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }

       /* for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() == 1){
                list.add(m.getKey());
            }
        }*/

       map.forEach((k,v ) -> {
        if(v == 1)
            list.add(k);
       });


        //System.out.println(map);
        return list;
    }

    //O(1)
    //works for only one non repeatative number
    public int getNonRepeatingElement1(int[] arr){
        int res = arr[0];

        for(int i=1; i<arr.length; i++){
            res = res ^ arr[i];
        }
        return  res;
    }
}
