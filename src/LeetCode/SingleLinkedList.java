package LeetCode;

import javafx.beans.binding.When;

public class SingleLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public static void main(String[] args) {
        SingleLinkedList obj = new SingleLinkedList();
        obj.createList(1);
        obj.createList(2);
        obj.createList(3);
        obj.createList(4);
        obj.createList(5);
        obj.createList(6);
        obj.createList(7);
        obj.createList(8);

        //create loop
        /*Node loopNode = new Node(3);
        obj.createList(new Node(1));
        obj.createList(new Node(2));
        obj.createList(loopNode);
        obj.createList(new  Node(4));
        obj.createList(new Node(5));
        obj.createList(new Node(6));
        obj.createList(loopNode);
        obj.isLoop();*/

        obj.printList();
        obj.rotateListByK(7);
        obj.printList();
        /*obj.insertAtK(10,3);
        obj.printList();
        obj.reverse();
        obj.printList();
        obj.reverseSecondHalfFromK(4);
        obj.printList();
        obj.reverseFirstHalfFromK(5);
        obj.printList();
        obj.deleteNode(4);
        obj.printList();
        obj.deleteKNodeFromEnd(3);
        obj.printList();*/
        
        //obj.checkPalindrome();
    }

    private void rotateListByK(int k) {
        int len = 1;
        Node node = head;
        while (node.next != null){
            node = node.next;
            len++;
        }

        k = k%len;

        node.next = head;
        Node tmp = head;
        for (int i=1; i<len-k; i++){
            tmp = tmp.next;
        }
        head = tmp.next;
        tmp.next = null;
    }

    public void createList(Node node){
        if(head == null){
            head = node;
        } else {
            Node tmp = head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    public void isLoop(){
        Node fastNode, slowNode;
        fastNode=slowNode=head;
        boolean flag = false;
        while (fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if(fastNode == slowNode){
                System.out.println("linked list is loop");
                flag = true;
                break;
            }
        }
        if (flag){
            Node tmp = head;
            while (tmp != fastNode){
                tmp = tmp.next;
                fastNode = fastNode.next;
            }
            System.out.println("loop node id : "+ tmp.data);
        }

    }

    private void checkPalindrome() {
        Node fastNode,slowNode;
        fastNode=slowNode=head;
        while (fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        Node cur = slowNode.next;
        Node prev,next;
        prev=next=null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur; cur=next;
        }
        Node tmp = head;
        while (tmp.next != null && prev.next != null){
            if(tmp.data == prev.data){
                tmp = tmp.next;
                prev = prev.next;
            } else {
                System.out.println("not palindrome");
                return;
            }
        }
        System.out.println("palindrome");

    }

    public void createList(int data){
        Node node = new Node(data);

        if(head == null){
            head = node;
        } else{
            Node tmp = head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }

    }

    public void insertAtK(int data, int k){
        Node node = new Node(data);
        Node tmp = head;
         for (int i=1; i<k-1; i++){
             tmp = tmp.next;
         }
         node.next = tmp.next;
         tmp.next = node;
    }

    public void reverse(){
        Node cur = head;
        Node pre,next;
        pre = next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
    }

    public void reverseSecondHalfFromK(int k){
        Node firstHalf = head;
        for (int i=1; i<k-1;i++){
            firstHalf = firstHalf.next;
        }
        Node secondHalf = firstHalf.next;
        firstHalf.next = null;
        Node pre,next;
        pre=next=null;
        while (secondHalf != null){
            next = secondHalf.next;
            secondHalf.next = pre;
            pre = secondHalf;
            secondHalf = next;
        }
        Node tmp = head;
        while (tmp.next != null)
            tmp = tmp.next;

        tmp.next = pre;

    }

    public void reverseFirstHalfFromK(int k){
        Node firstHalf = head;
        for (int i=1; i<k-1; i++)
            firstHalf = firstHalf.next;

        Node secondHalf = firstHalf.next;
        firstHalf.next = null;

        Node cur = head;
        Node pre,next;
        pre=next=null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
        Node tmp = head;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = secondHalf;
    }

    public void deleteNode(int pos){
        Node tmp = head;
        for (int i=1; i<pos-1; i++){
            tmp = tmp.next;
        }

        Node node = tmp.next.next;
        tmp.next = node;

    }

    public void deleteKNodeFromEnd(int k){
        Node node1 , node2;
        node2=node1=head;
        for(int i=0; i<k; i++){
            node1 = node1.next;
        }

        while (node1.next != null){
            node1 = node1.next;
            node2 = node2.next;
        }

        Node tmp = node2.next.next;
        node2.next = tmp;

    }
    private void printList() {
        Node tmp = head;
        while (tmp != null){
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }


}
