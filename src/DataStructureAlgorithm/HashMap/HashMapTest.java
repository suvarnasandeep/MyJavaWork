package DataStructureAlgorithm.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    public  static void main(String[] args){

        Map<String, String> tmpmap = new HashMap<>();
        tmpmap.put("1", "suvarna");
        tmpmap.put("2", "anup");
        tmpmap.put("3", "rakshi");


        for(String str : tmpmap.keySet()){
            System.out.println(str + " - " + tmpmap.get(str));
        }
        System.out.println("---------------------------");

        for(Map.Entry<String, String> entry : tmpmap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("----------------------------");
        Iterator<Map.Entry<String, String>> entries = tmpmap.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<String, String> entry = entries.next();
            if(entry.getKey().equals("1")){
                tmpmap.put("1", "Sandeepaaaa");
            }
            System.out.println(entry.getKey() + " - " + entry.getValue());

        }

        System.out.println("--------------------------------");
        tmpmap.forEach((k,v) -> System.out.println(k + "-" + v));
    }


}
