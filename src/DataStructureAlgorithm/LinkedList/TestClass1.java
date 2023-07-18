package DataStructureAlgorithm.LinkedList;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class TestClass1 {

    int cap;
    int min = 1;
    Map<Integer, Integer> keyValueMap = new HashMap<>();
    Map<Integer, Integer> keyFreqMap = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqKeysMap = new HashMap<>();

    public TestClass1(int cap){
        this.cap = cap;
        freqKeysMap.put(1,new LinkedHashSet());
    }

    public int get(int key){
        if(!keyValueMap.containsKey(key)){
            return -1;
        }
        int freq = keyFreqMap.get(key);
        freqKeysMap.get(freq).remove(key);

        if(freq == min && freqKeysMap.get(freq).size() ==0){
            min++;
        }

        if(!freqKeysMap.containsKey(freq+1)){
            freqKeysMap.put(freq+1, new LinkedHashSet());
        }

        freqKeysMap.get(freq+1).add(key);
        keyFreqMap.put(key,freq+1);
        return keyValueMap.get(key);
    }

    public void put(int key, int val){
        if(keyValueMap.containsKey(key)){
            keyValueMap.put(key, val);
            get(key);
            return;
        }
        if(keyValueMap.size() >= cap){

            int keyRemove = freqKeysMap.get(min).iterator().next();
            freqKeysMap.get(min).remove(keyRemove);
            keyValueMap.remove(keyRemove);
            keyFreqMap.remove(keyRemove);

        }

        keyValueMap.put(key, val);
        keyFreqMap.put(key, 1);
        freqKeysMap.get(1).add(key);
        min=1;
    }

}
