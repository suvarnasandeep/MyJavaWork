package DataStructureAlgorithm.LinkedList.Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicatesSLL {
    NodeSLL head;
    NodeSLL tail;
    int size;

    public NodeSLL createSLL(int val){
        NodeSLL node = new NodeSLL(val);
        head = node;
        tail = node;
        size++;
        return head;
    }

    public NodeSLL insertSLL(int val){
        NodeSLL node = new NodeSLL(val);
        tail.next = node;
        tail = node;
        size++;
        return head;
    }

    public void deleteDups(NodeSLL node){
        print(node);
        NodeSLL cur = node;
        NodeSLL prev = null;
        Set<Integer> set = new HashSet<>();
        while (cur != null){
            if(! set.contains(cur.val)){
                set.add(cur.val);
                prev = cur;
            } else {
                prev.next = cur.next;
                size--;
            }
            cur = cur.next;
        }
        print(node);
    }

    public void print(NodeSLL headNode){
        NodeSLL node = headNode;
        while (node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesSLL obj = new RemoveDuplicatesSLL();
        obj.createSLL(1);
        obj.insertSLL(2);
        obj.insertSLL(1);
        obj.insertSLL(4);
        obj.insertSLL(5);
        obj.insertSLL(4);
        NodeSLL node = obj.insertSLL(3);
        obj.print(node);
        obj.deleteDups(node);
    }
}
