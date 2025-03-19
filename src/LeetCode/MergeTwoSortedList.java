package LeetCode;

public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(){

        }
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        printList(list1);
        printList(list2);

        ListNode mList = mergeLists(list1,list2);
        printList(mList);
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

    private static void printList(ListNode list) {
        ListNode tmp = list;
        while (list != null){
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.println();
    }
}
