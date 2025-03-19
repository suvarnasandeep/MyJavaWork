package LeetCode.Utils;


import LeetCode.MergeTwoSortedList;

import java.util.List;

public class LinkedListBuilder {
    public static ListNode createSLL(List<Integer> list){
        ListNode head = null;
        ListNode tmp = null;
        for (int val : list){
            ListNode node = new ListNode(val);
            if(head == null){
                head = node;
                tmp = node;
            } else {
                tmp.next = node;
                tmp = tmp.next;
            }
        }

        return head;
    }

    public static void printList(ListNode list) {
        ListNode tmp = list;
        while (list != null){
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.println();
    }
}
