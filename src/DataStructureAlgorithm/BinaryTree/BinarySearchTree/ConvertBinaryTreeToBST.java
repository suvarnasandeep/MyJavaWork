package DataStructureAlgorithm.BinaryTree.BinarySearchTree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/*
The idea is to traverse the binary tree and store its keys in a set. We know that an inorder traversal of
a binary search tree returns the nodes in sorted order, so traverse the tree again in an inorder fashion and
 put the keys present in the set (in sorted order) back to their correct position in the BST.
 */
public class ConvertBinaryTreeToBST {

    /* Construct the following tree
                   8
                 /   \
                /     \
               3       5
              / \     / \
             /   \   /   \
            10    2 4     6
        */
    public static void convertBinaryTreeToBST() {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        convertToBST(root);
    }

    public static void convertToBST(Node root){
        Set<Integer> set = new TreeSet<>();
        getData(root,set);

        Iterator<Integer> it = set.iterator();
        constructBST(root, it);
        BSTUtil.printBST(root);

        constructUsingSecondApproach(set);
    }

    public static void getData(Node root, Set<Integer>set){
        if(root != null){
            getData(root.left, set);
            set.add(root.data);
            getData(root.right, set);
        }
    }

    public static void constructBST(Node root, Iterator<Integer> it){
        if(root != null){
            constructBST(root.left, it);
            root.data = it.next();
            constructBST(root.right, it);
        }
    }

    public static void constructUsingSecondApproach(Set<Integer> set){

        int size = set.size();
        int[] arr = convertSetToInt(set);

        Node node = constructBST1(arr, 0,arr.length-1);
        System.out.println();
        System.out.println("--------------------------------");
        BSTUtil.printBST(node);
    }

    private static int[] convertSetToInt(Set<Integer> set) {
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Node constructBST1(int[] arr, int start, int end) {
        if(start > end){
            return null;
        }

        int mid = (start + end) /2;
        Node node = new Node(arr[mid]);

        node.left = constructBST1(arr, start, mid-1);
        node.right = constructBST1(arr, mid+1, end);

        return node;
    }

}
