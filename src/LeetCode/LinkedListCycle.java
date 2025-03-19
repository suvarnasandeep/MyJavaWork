package LeetCode;

import LeetCode.Utils.ListNode;

public class LinkedListCycle {


    public static boolean hasCycle(ListNode head){
        ListNode slowNode, fastNode;
        slowNode=fastNode=head;
        while (fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode){
                return true;
            }
        }
        return false;
    }
}
