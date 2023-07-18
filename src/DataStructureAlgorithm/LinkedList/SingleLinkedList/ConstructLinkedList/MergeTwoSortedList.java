package DataStructureAlgorithm.LinkedList.SingleLinkedList.ConstructLinkedList;

public class MergeTwoSortedList {

    static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    /*
    list1 = 5->7->9
    list2 = 3->4->8->10
    output = 3->4->5->7->8->9->10
     */
    public static void main(String[] args) {
        Node listNode1 = new Node(5);
        listNode1.next = new Node(7);
        listNode1.next.next = new Node(9);
        printList(listNode1);

        Node listNode2 = new Node(3);
        listNode2.next = new Node(4);
        listNode2.next.next = new Node(8);
        listNode2.next.next.next = new Node(10);
        printList(listNode2);
        Node resultList = mergeList(listNode1,listNode2);

        printList(resultList);
    }

    /*
    list1 = 5->7->9
    list2 = 3->4->8->10
    output = 3->4->5->7->8->9->10
    Time Complexity: O(N) Space Complexity: O(1)
    https://www.scaler.com/topics/merge-two-sorted-linked-lists/
     */
    public static Node mergeList(Node node1, Node node2){
        Node resultNode = new Node(0);
        Node tail = resultNode;
        while (true){
            if(node1 == null){
                tail.next = node2;
                break;
            } else if(node2 == null){
                tail.next = node1;
                break;
            }

            if(node1.data <= node2.data){
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        return  resultNode.next;

    }

    public static void printList(Node node){
        while (node != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }
}
