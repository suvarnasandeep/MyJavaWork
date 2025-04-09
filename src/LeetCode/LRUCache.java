package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key, val;
        Node next, prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public void put( int key, int val){
        if(map.containsKey(key)){
            removeNode(map.get(key));
        } else if (map.size() >= capacity) {
            removeNode(tail.prev);
        }
        insertNode(new Node(key, val));
    }

    public int get(int key){
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        removeNode(node);
        insertNode(node);
        return node.val;
    }

    public void removeNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertNode(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1,10);
        cache.put(2,15);
        cache.put(3,20);
        cache.printList();
        System.out.println(cache.get(2));
        cache.printList();
        System.out.println(cache.get(1));
        cache.printList();
        cache.put(4,40);
        cache.printList();

    }

    public void printList(){
        Node tmp = head;

        while(tmp != null){
            System.out.print(tmp.val + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
