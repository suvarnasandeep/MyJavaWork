package LeetCode.Test;

import LeetCode.LFUCacheDLL;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    int capacity, curSize, minFreq;
    Map<Integer, Node> cacheMap = new HashMap<>();
    Map<Integer, DLL> freqMap = new HashMap<>();

    LFUCache(int capacity){
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;
    }

    public int get(int key){
        if(!cacheMap.containsKey(key))
            return -1;

        Node node =cacheMap.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int val){
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            node.val = val;
            update(node);
        } else {
            curSize++;
            if (curSize > capacity){
                DLL minList = freqMap.get(minFreq);
                cacheMap.remove(minList.tail.prev.key);
                minList.removeNode(minList.tail.prev);
                curSize--;
            }
            minFreq = 1;
            Node node = new Node(key, val);
            DLL list = freqMap.getOrDefault(1, new DLL());
            list.insertNode(node);
            cacheMap.put(key, node);
            freqMap.put(1, list);
        }
    }

    public void update(Node node){
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.removeNode(node);
        node.freq++;

        if(freq == minFreq && list.size == 0)
            minFreq++;

        DLL newList = freqMap.getOrDefault(freq+1, new DLL());
        newList.insertNode(node);
        freqMap.put(freq+1, newList);
    }



    class Node {
        int key, val, freq;
        Node prev, next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
            this.prev = null;
            this.next = null;
        }
    }

    class DLL{
        int size;
        Node head, tail;

        DLL(){
            this.size = 0;
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public void insertNode(Node node){
            size++;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
        }

        public void removeNode(Node node){
            size--;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
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
