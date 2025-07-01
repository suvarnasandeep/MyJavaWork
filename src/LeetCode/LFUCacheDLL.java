package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
https://www.youtube.com/watch?v=0PSB9y8ehbk&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=17
https://www.enjoyalgorithms.com/blog/least-frequently-used-cache
https://github.com/striver79/SDESheet/blob/main/LFUCacheJava
*/
public class LFUCacheDLL {

    int capacity;
    int curSize;
    int minFreq;
    Map<Integer, Node> cacheMap = new HashMap<>();
    Map<Integer, DLL> freqMap = new HashMap<>();
    /**
     *  capacity: total capacity of LFU Cache
     *  curSize: current size of LFU cache
     *  minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
     *  cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
     *  frequencyMap: a hash map that has key to linked list mapping, which used for storing all
     * double linked list by their frequencies
     * */

    class Node{
        int key;
        int val;
        int freq;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            freq = 1;
            next = null;
            prev = null;
        }
    }

    class DLL{
        int size;
        Node head;
        Node tail;
        DLL(){
            size = 0;
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node node){
            node.next = head.next;
            head.next = node;
            node.prev = head;
            node.next.prev = node;
            size++;
        }

        public void removeNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    LFUCacheDLL(int capacity){
        this.capacity = capacity;
        this.minFreq = 0;
        this.curSize = 0;
    }

    public int get(int key){
        if(!cacheMap.containsKey(key))
            return -1;

        Node node = cacheMap.get(key);
        update(node);
        return node.val;
    }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value){
        if(cacheMap.containsKey(key)){
            Node curNode = cacheMap.get(key);
            curNode.val = value;
            update(curNode);
        } else {
            curSize++;
            if(curSize > capacity){
                DLL minFreqList = freqMap.get(minFreq);
                cacheMap.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFreq=1;
            Node newNode = new Node(key, value);
            DLL list = freqMap.getOrDefault(1, new DLL());
            list.addNode(newNode);
            freqMap.put(1,list);
            cacheMap.put(key, newNode);
        }
    }

    public void update(Node node){
        int curFreq = node.freq;
        DLL list = freqMap.get(curFreq);
        list.removeNode(node);

        node.freq++;
        if(curFreq == minFreq && list.size == 0){
            minFreq++;
        }
        DLL curList = freqMap.getOrDefault(node.freq, new DLL());
        curList.addNode(node);
        freqMap.put(node.freq, curList);
    }

    public static void main(String[] args) {
        LFUCacheDLL cache = new LFUCacheDLL(2);
        cache.put(1,10);
        cache.put(2,20);
        System.out.println(cache.get(1));
        cache.put(3,30);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,40);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
