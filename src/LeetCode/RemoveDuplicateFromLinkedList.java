package LeetCode;

import LeetCode.Utils.LinkedListBuilder;
import LeetCode.Utils.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveDuplicateFromLinkedList {
    /**
     * Input: head = [1,1,2]
     * Output: [1,2]
     * Input: head = [1,1,2,3,3]
     * Output: [1,2,3]
     */
    public static void main(String[] args) {

        ListNode list = LinkedListBuilder.createSLL(Arrays.asList(1,1,1,3,3,2));

        LinkedListBuilder.printList(deleteDUplicates(list));
    }

    private static ListNode deleteDUplicates(ListNode head) {
        if(head == null)
            return head;

        ListNode res = head;

        while (head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
