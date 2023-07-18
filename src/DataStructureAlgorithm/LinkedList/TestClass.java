package DataStructureAlgorithm.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class TestClass {

    Node head;

    class Node {
        Integer data;
        Node next;

        public Node(Integer data) {
            this.data = data;
            next = null;
        }
    }




    public static void main(String[] args) {
        TestClass obj = new TestClass();
        //        TestClass obj = new TestClass();
//        obj.createList(1);
//        obj.createList(2);
//        obj.createList(3);
//        obj.createList(4);
//        obj.createList(5);
//        obj.createList(4);
//        obj.createList(3);
//        obj.createList(2);
//        obj.createList(1);

        //obj.printList();

        //obj.reverse();

        //obj.reverseSendHalfFromN(3);
        //obj.printList();
        //obj.reverseFirstHalfFromN(3);
        //obj.printList();
        //obj.reverseFirstHalf();
        //obj.reverseSecondHalf();
       //obj.isPalindrome();
       // obj.printList();


//
//        obj.insertAtBegining(33);
//        obj.insertAtBegining(3);
//        obj.printList();
//        obj.insertAtEnd(50);
//        obj.insertAtEnd(51);
//        obj.printList();
//
//        obj.insertAtK(2,22);
//        obj.insertAtK(4,44);
//        obj.printList();
//
//        System.out.println(obj.search(2));
//
//        obj.deleteNode(3);
//        obj.printList();
//
//        obj.sortList();
//        obj.printList();

    }

    private void isPalindrome() {
        Node slowNode, fastNOde;
        slowNode = fastNOde = head;

        while(fastNOde != null && fastNOde.next!=null){
            fastNOde = fastNOde.next.next;
            slowNode = slowNode.next;
        }
        Node secondHalf = slowNode.next;
        slowNode.next = null;

        Node prev=null;Node next = null;
        while (secondHalf != null){
            next = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf=next;
        }

        Node cur = head;
        while (cur != null && prev != null){
            if(cur.data == prev.data){
               cur = cur.next;
               prev = prev.next;
            } else {
                System.out.println("not palindrome");
                return;
            }
        }
        System.out.println("palindrome");
    }

    private void reverseSecondHalf() {
        Node fastNode,slowNode;
        fastNode = slowNode = head;
        while(fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        Node secondHalf = slowNode.next;
        slowNode.next = null;

        Node prev = null;
        Node next = null;
        while(secondHalf != null){
            next = secondHalf.next;
            secondHalf.next = prev;

            prev = secondHalf;
            secondHalf = next;
        }

        Node next1 = head;
        while (next1.next != null){
            next1 = next1.next;
        }
        next1.next = prev;
    }

    private void reverseFirstHalf() {
        Node slowNode, fastNode;
        slowNode = fastNode = head;

        while(fastNode != null && fastNode.next!=null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        Node secondHalf = slowNode.next;
        slowNode.next=null;

        Node cur = head;
        Node prev, next;
        prev = next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
         head = slowNode;
        while (slowNode.next != null){
            slowNode = slowNode.next;
        }
        slowNode.next = secondHalf;

    }

    private void reverseFirstHalfFromN(int n) {
        Node tmp = head;
        for(int i=0;i<n;i++){
            tmp = tmp.next;
        }
        Node secondHalf = tmp.next;
        tmp.next = null;

        Node cur = head;
        Node prev = null;
        Node next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = tmp;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = secondHalf;
    }

    private void createList(int i) {
         Node node = new Node(i);
         Node tmp = head;
         if(head == null){
             head = node;
         } else {
             while(tmp.next != null){
                 tmp = tmp.next;
             }
             tmp.next = node;
         }
    }

    private void reverse(){
        Node cur = head;
        Node prev=null;
        Node next=null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        head = prev;

    }

    private void reverseSendHalfFromN(int n){
        Node firstHalf = head;

        for(int i=0; i<n; i++){
            firstHalf = firstHalf.next;
        }

        Node curr = firstHalf.next;
        firstHalf.next = null;

        Node next = null;
        Node prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = prev;

    }

    private void printList() {

        Node tmp = head;
        System.out.print("[ ");
        while (tmp != null){
            System.out.print(tmp.data + "-> ");
            tmp = tmp.next;
        }
        System.out.println(" ]");
    }

    private void insertAtBegining(int data){

        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    private void insertAtEnd(int data){
        Node node = new Node(data);
        Node tmp = head;

        while (tmp.next != null){
            tmp = tmp.next;
        }

        tmp.next = node;
    }

    private  void insertAtK(int pos, int data){
        Node tmp = head;
        Node node = new Node(data);
        for(int i=1; i<pos; i++){
            tmp = tmp.next;
        }

        node.next = tmp.next;
        tmp.next = node;
    }

    private boolean search(int data){
        Node tmp = head;

        while(tmp != null){
            if(tmp.data == data){
                return  true;
            }
            tmp = tmp.next;
        }
        return  false;
    }

    private void deleteNode(int position){
        Node tmp = head;

        if(position == 0){
            head = tmp.next;
        }

        for(int i = 1 ; i < position; i++){
            tmp = tmp.next;
        }

        Node node = tmp.next.next;
        tmp.next = node;

    }

    private void sortList(){
        Node current = head;
        Node index;
        int tmp;

        while(current != null){
            index = current.next;
            while (index != null){
                if(current.data > index.data){
                    tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }

            current = current.next;
        }

    }
}
