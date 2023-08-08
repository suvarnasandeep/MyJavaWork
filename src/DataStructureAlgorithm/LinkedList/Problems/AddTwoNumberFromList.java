package DataStructureAlgorithm.LinkedList.Problems;

public class AddTwoNumberFromList {
    static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    /*
    list1 = 2->4->3
    list2 = 5->6->7->9
    output = 7->0->1->0->1
     */
    private static Node addTwoNumbers(Node listNode1, Node listNode2) {
        Node dummy = new Node(0);
        Node tmp = dummy;
        int carry = 0;
        while(listNode1 != null || listNode2 !=null || carry == 1){
            int sum = 0;
            if(listNode1 != null){
                sum += listNode1.data;
                listNode1 = listNode1.next;
            }
            if(listNode2 != null){
                sum += listNode2.data;
                listNode2 = listNode2.next;
            }

            sum += carry;
            carry = sum/10;
            Node node = new Node(sum%10);
            tmp.next = node;
            tmp = tmp.next;
        }
        return  dummy.next;
    }

    public static void printList(Node node){
        while (node != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }

    /*
    list1 = 2->4->3
    list2 = 5->6->7->9
    output = 7->0->1->0->1
    https://www.youtube.com/watch?v=LBVsXSMOIk4&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=6
     */
    public static void main(String[] args) {
<<<<<<< Updated upstream
=======
        //sandeep
>>>>>>> Stashed changes
        Node listNode1 = new Node(2);
        listNode1.next = new Node(4);
        listNode1.next.next = new Node(3);
        printList(listNode1);

        Node listNode2 = new Node(5);
        listNode2.next = new Node(6);
        listNode2.next.next = new Node(7);
        listNode2.next.next.next = new Node(9);
        printList(listNode2);
        Node resultList = addTwoNumbers(listNode1,listNode2);

        printList(resultList);
    }
}
