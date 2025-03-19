package LeetCode;

import LeetCode.Utils.LinkedListBuilder;
import LeetCode.Utils.ListNode;

import java.util.Arrays;
import java.util.List;

public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode node = LinkedListBuilder.createSLL(Arrays.asList(1,2,3,4,5,6,7,8));
        LinkedListBuilder.printList(node);

        ListNode res = rotateRight(node, 3);
        LinkedListBuilder.printList(res);
    }

    public static  ListNode rotateRight(ListNode head, int k) {

        if(head == null)
            return new ListNode();

        ListNode node = head;
        int len = 1;
        while (node.next != null){
            node = node.next;
            len++;
        }

        k = k%len;
        node.next = head;

        ListNode tmp = head;
        for (int i=1; i<len-k; i++){
            tmp = tmp.next;
        }

        ListNode res = tmp.next;
        tmp.next = null;

        return res;
    }

}
