package LeetCode;

import LeetCode.Utils.LinkedListBuilder;
import LeetCode.Utils.ListNode;

import java.util.Arrays;

public class IntersectionLinkedList {

    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while (tmp1 != tmp2){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;

            if(tmp1 == tmp2)
                return tmp1;

            if(tmp1 == null)
                tmp1 = headB;
            if(tmp2 == null)
                tmp2 = headA;
        }
        return tmp1;*/


    //utility function to check presence of intersection
    static ListNode intersectionPresent(ListNode head1,ListNode head2) {
        ListNode d1 = head1;
        ListNode d2 = head2;

        while(d1 != d2) {
            d1 = d1 == null? head2:d1.next;
            d2 = d2 == null? head1:d2.next;
        }

        return d1;
    }

    //utility function to print linked list created
    static void printList(ListNode head) {
        while(head.next != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String args[]) {
        // creation of both lists
        /*Node head = null;
        head=insertNode(head,2);
        head=insertNode(head,4);
        head=insertNode(head,6);
        Node head1 = head;
       /* head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec=insertNode(headSec,3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists*/

        ListNode head1 = LinkedListBuilder.createSLL(Arrays.asList(2,4,6));
        ListNode head2 = LinkedListBuilder.createSLL(Arrays.asList(1,5));
        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);
        //checking if intersection is present
        ListNode answerNode = intersectionPresent(head1,head2);
        if(answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is "+answerNode.val);

    }

}
