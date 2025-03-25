package LeetCode;

import LeetCode.Utils.LinkedListBuilder;
import LeetCode.Utils.ListNode;

import java.util.Arrays;

public class ValidPalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = LinkedListBuilder.createSLL(Arrays.asList(1,2,3,4,3,2,1));
        System.out.println(isPalindrome(node));
        LinkedListBuilder.printList(node);
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow.next);
        ListNode n = rev;
        slow.next = null;
        while(rev != null) {
            if(head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        head.next = reverse(n);
        return true;
    }

    private static ListNode reverse(ListNode head){
        ListNode pre, next;
        pre = next = null;
        ListNode cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
