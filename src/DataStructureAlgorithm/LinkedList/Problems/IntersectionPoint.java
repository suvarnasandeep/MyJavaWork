package DataStructureAlgorithm.LinkedList.Problems;

import DataStructureAlgorithm.LinkedList.Node.Node;

public class IntersectionPoint {

    //https://www.youtube.com/watch?v=u4FWXfgS8jw&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=7
    public Node intersectionOfTwoList(Node head1, Node head2){
    Node d1 = head1;
    Node d2 = head2;

    while (d1 != d2){
        d1 = d1 == null ? head2 : d1.next;
        d2 = d2 == null ? head1 : d2.next;
    }
    return d1;
    }
}
