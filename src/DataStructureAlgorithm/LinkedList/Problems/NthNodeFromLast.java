package DataStructureAlgorithm.LinkedList.Problems;

public class NthNodeFromLast {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        Node head;
        Node tail;
        public void createSLL(int data){
            Node node = new Node(data);
            if(head == null){
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        public void print(Node headNode){
            Node node = headNode;
            while (node != null){
                System.out.print(node.data + " -> ");
                node = node.next;
            }
            System.out.println();
        }

        public void getNthNodeFromLast(Node node, int n){
            Node p1 = node;
            Node p2 = node;
            for(int i=0; i<n; i++){
                p2 = p2.next;
            }
            while (p2 != null){
                p2 = p2.next;
                p1 = p1.next;
            }
            System.out.println(p1.data);
        }

        public static void main(String[] args) {
            NthNodeFromLast obj = new NthNodeFromLast();
            obj.createSLL(1);
            obj.createSLL(2);
            obj.createSLL(3);
            obj.createSLL(4);
            obj.createSLL(5);
            obj.print(obj.head);
            obj.getNthNodeFromLast(obj.head,2);
        }

}
