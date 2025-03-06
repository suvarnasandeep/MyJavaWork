package DataStructureAlgorithm.Stack;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=OUIw_OtgdTo
 * https://github.com/Sunchit/Coding-Decoded/blob/master/Leetcode2023/January2023/Java/LFUCache.java
 */
public class LFUCacheLHS {

    int capacity;
    int min = 1;

    Map<Integer, Integer> keyValueMap = new HashMap<>();
    Map<Integer, Integer> keyFreqMap = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqKeysMap = new HashMap<>();

    public LFUCacheLHS(int capacity){
        this.capacity = capacity;
        freqKeysMap.put(1,new LinkedHashSet<>());
    }

    public int get(int key){
        if(!keyValueMap.containsKey(key)){
            return -1;
        }

        int frequency = keyFreqMap.get(key);
        freqKeysMap.get(frequency).remove(key);

        if(frequency == min && freqKeysMap.get(frequency).size() == 0){
            min++;
        }
        if(!freqKeysMap.containsKey(frequency+1)){
            freqKeysMap.put(frequency+1, new LinkedHashSet<>());
        }

        freqKeysMap.get(frequency+1).add(key);
        keyFreqMap.put(key, frequency+1);

        return keyValueMap.get(key);
    }

    public void put(int key, int value){
        if(capacity <= 0 ){
            return;
        }
        if(keyValueMap.containsKey(key)){
            keyValueMap.put(key,value);
            get(key);
            return;
        }
        if(keyValueMap.size() >= capacity){
            int keyToRemove = freqKeysMap.get(min).iterator().next();
            freqKeysMap.get(min).remove(keyToRemove);
            keyValueMap.remove(keyToRemove);
            keyFreqMap.remove(keyToRemove);
        }
        keyValueMap.put(key,value);
        keyFreqMap.put(key, 1);
        min=1;
        freqKeysMap.get(1).add(key);
    }

    public static void main(String[] args) {
        LFUCacheLHS obj = new LFUCacheLHS(2);
        obj.put(1,100);
        obj.put(2,200);
        System.out.println(obj.get(1));
        obj.put(3,300);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        obj.put(4,400);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

//        LFUCacheLHS obj = new LFUCacheLHS(3);
//        obj.put(1,10);
//        obj.put(2,20);
//        obj.put(3,30);
//        obj.put(4,40);
//        System.out.println(obj.get(3));
//        System.out.println(obj.get(2));
//        System.out.println(obj.get(4));
//        obj.put(5,50);
//        System.out.println(obj.get(4));
    }
}
