package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=OUIw_OtgdTo
 * https://github.com/Sunchit/Coding-Decoded/blob/master/Leetcode2023/January2023/Java/LFUCache.java
 */
public class LFUCacheLHS {
    int capacity;
    int min;

    Map<Integer, Integer> keyValMap = new HashMap<>();
    Map<Integer, Integer> keyFreqMap = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqKeyMap = new HashMap<>();

    LFUCacheLHS(int capacity){
        this.capacity = capacity;
        min = 1;
        freqKeyMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key){
        if(!keyValMap.containsKey(key))
            return -1;

        int freq = keyFreqMap.get(key);
        freqKeyMap.get(freq).remove(key);

        if(freq == min && freqKeyMap.get(freq).size() == 0){
            min++;
        }

        if(!freqKeyMap.containsKey(freq+1)){
            freqKeyMap.put(freq+1, new LinkedHashSet<>());
        }

        freqKeyMap.get(freq+1).add(key);
        keyFreqMap.put(key, freq+1);

        return keyValMap.get(key);
    }

    public void put(int key, int val){
        if(keyValMap.containsKey(key)){
            keyValMap.put(key,val);
            get(key);
            return;
        }

        if(keyValMap.size() >= capacity){
            int keyToRemove = freqKeyMap.get(min).iterator().next();
            freqKeyMap.get(min).remove(keyToRemove);
            keyFreqMap.remove(keyToRemove);
            keyValMap.remove(keyToRemove);
        }

        keyValMap.put(key,val);
        keyFreqMap.put(key, 1);
        freqKeyMap.get(1).add(key);
        min = 1;
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
/**
        LFUCacheLHS obj = new LFUCacheLHS(3);
        obj.put(1,10);
        obj.put(2,20);
        obj.put(3,30);
        obj.put(4,40);
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        System.out.println(obj.get(4));
        obj.put(5,50);
        System.out.println(obj.get(4));
   */
    }
}
