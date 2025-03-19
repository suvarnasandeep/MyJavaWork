package LeetCode;

public class LinkedListCycle {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

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
