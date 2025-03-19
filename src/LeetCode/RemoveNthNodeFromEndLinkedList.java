package LeetCode;

import LeetCode.Utils.LinkedListBuilder;
import LeetCode.Utils.ListNode;

import java.util.Arrays;

public class RemoveNthNodeFromEndLinkedList {

    public static void main(String[] args) {
        ListNode node = LinkedListBuilder.createSLL(Arrays.asList(1,2,3,4,5,6));
        //ListNode node = LinkedListBuilder.createSLL(Arrays.asList(1));

        LinkedListBuilder.printList(node);

        LinkedListBuilder.printList(removeNthFromEnd(node, 1));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            dummy = dummy.next;
        }

        dummy.next = dummy.next.next;

        return res.next;
    }
}
