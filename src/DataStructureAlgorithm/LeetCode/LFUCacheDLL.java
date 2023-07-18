package DataStructureAlgorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/*
https://www.youtube.com/watch?v=0PSB9y8ehbk&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=17
https://www.enjoyalgorithms.com/blog/least-frequently-used-cache
https://github.com/striver79/SDESheet/blob/main/LFUCacheJava
*/
public class LFUCacheDLL {
    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, Node> cacheMap;
    Map<Integer, DoubleLinkedList> frequencyMap;
    /**
     *  capacity: total capacity of LFU Cache
     *  curSize: current size of LFU cache
     *  minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
     *  cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
     *  frequencyMap: a hash map that has key to linked list mapping, which used for storing all
     * double linked list by their frequencies
     * */

    public LFUCacheDLL(int capacity){
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cacheMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key){
        Node node = cacheMap.get(key);
        if(node == null){
            return -1;
        }
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
    public void put(int key, int value) {
        // corner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }

        if (cacheMap.containsKey(key)) {
            Node curNode = cacheMap.get(key);
            curNode.val = value;
            update(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cacheMap.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            Node newNode = new Node(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cacheMap.put(key, newNode);
        }
    }

    private void update(Node node) {
        int curFreq = node.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(node);

        /**
        if current list the the last list which has lowest frequency and current node is the only node in that list
        we need to remove the entire list and then increase min frequency value by 1
        **/
        if(curFreq == minFrequency && curList.listSize == 0){
            minFrequency++;
        }
        node.frequency++;
        /**
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        **/
         DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
        newList.addNode(node);
        frequencyMap.put(node.frequency,newList);
    }

    class Node {
        int key;
        int val;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DoubleLinkedList {
        int listSize;
        Node head;
        Node tail;

        public  DoubleLinkedList(){
            this.listSize = 0;
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node curNode){
            Node nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        public void removeNode(Node curNode){
            Node prevNode = curNode.prev;
            Node nextNode = curNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

    public static void main(String[] args) {
        LFUCacheDLL cache = new LFUCacheDLL(2);
        cache.put(1,10);
        cache.put(2,20);
        System.out.println(cache.get(1));
        cache.put(3,30);
        System.out.println(cache.get(2));
    }

}
