package LeetCode;

import LeetCode.Utils.ListNode;

public class IntersectionLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
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
        return tmp1;
    }
}
