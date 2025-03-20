package LeetCode;

import LeetCode.Utils.LinkedListBuilder;
import LeetCode.Utils.ListNode;

import java.util.Arrays;

public class ReverseLinkedListII {
    /**
     * Input: head = [1,2,3,4,5,6], left = 2, right = 5
     * Output: [1,4,3,2,5]
     */
    public static void main(String[] args) {
        ListNode list = LinkedListBuilder.createSLL(Arrays.asList(1,2,3,4,5,6));

        LinkedListBuilder.printList(reverseBetween(list, 1,2));
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode preNode = dummy;
        ListNode currNode = head;

        for (int i=0; i<left-1; i++){
            preNode = preNode.next;
            currNode = currNode.next;
        }
        ListNode endRef = currNode;

        ListNode prev = null;
        for (int j=0; j<=right-left; j++){
            ListNode next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        preNode.next = prev;
        endRef.next = currNode;

        return dummy.next;
    }
}
