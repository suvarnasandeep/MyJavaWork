package LeetCode;

import LeetCode.Utils.LinkedListBuilder;
import LeetCode.Utils.ListNode;

import java.util.Arrays;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = LinkedListBuilder.createSLL(Arrays.asList(1,2,4));
        ListNode list2 = LinkedListBuilder.createSLL(Arrays.asList(1,3,4));
        LinkedListBuilder.printList(list1);
        LinkedListBuilder.printList(list2);

        LinkedListBuilder.printList(mergeLists(list1,list2));
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode head = new ListNode();
        ListNode cur = head;

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return head.next;
    }

}
