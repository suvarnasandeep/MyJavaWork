package LeetCode;

import LeetCode.Utils.LinkedListBuilder;
import LeetCode.Utils.ListNode;

import java.util.Arrays;

public class AddTwoNumbersLinkedList {
    public static void main(String[] args) {
        ListNode list1 = LinkedListBuilder.createSLL(Arrays.asList(2, 4, 3));
        ListNode list2 = LinkedListBuilder.createSLL(Arrays.asList(5, 6, 4));

        LinkedListBuilder.printList(list1);
        LinkedListBuilder.printList(list2);

        LinkedListBuilder.printList(addTwoNumbers(list1,list2));
    }

    private static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode();
        ListNode res = cur;
        int total = 0;
        int carry = 0;

        while (list1 != null || list2 != null || carry != 0){
            total = carry;

            if (list1 != null){
                total += list1.val;
                list1 = list1.next;
            }
            if(list2 != null){
                total += list2.val;
                list2 = list2.next;
            }

            carry = total/10;
            int num = total%10;
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        return res.next;
    }
}
