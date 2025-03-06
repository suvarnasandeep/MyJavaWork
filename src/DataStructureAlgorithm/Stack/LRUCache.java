package DataStructureAlgorithm.Stack;

import java.util.HashMap;
import java.util.Map;

//https://takeuforward.org/data-structure/implement-lru-cache/
//https://www.youtube.com/watch?v=Xc4sICC8m4M&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=16
public class LRUCache {

    class Node {
        int key, val;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);;

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

    public LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key, val));
    }

    public void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
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
