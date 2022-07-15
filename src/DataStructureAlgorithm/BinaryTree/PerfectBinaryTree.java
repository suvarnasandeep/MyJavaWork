package DataStructureAlgorithm.BinaryTree;

public class PerfectBinaryTree {
    /*
    A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes and all the leaf nodes are at the same level.
              18
           /       \
         15         30
        /  \        /  \
      40    50    100   40
        Find depth of any node (in below tree we find depth of leftmost node). Let this depth be d.
        Now recursively traverse the tree and check for following two conditions.
        Every internal node should have both children non-empty
        All leaves are at depth ‘d’

        Complexity Analysis:
        Time complexity: O(n)
        Space Complexity: O(n)
     */
    public static void perfectBinaryTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right= new Node(5);
        root.right.left = new Node(4);
        root.right.right= new Node(5);
       // root.left.left.left = new Node(6);
        //root.left.left.right = new Node(7);

        if(isPerfectBinaryTree(root)){
            System.out.println("The tree is perfect tree");
        } else {
            System.out.println("The tree is not a perfect binary tree");
        }
    }

    private static boolean isPerfectBinaryTree(Node root) {
        int dept = findDepth(root);

        return isPerfectBinaryTree(root, dept, 0);
    }

    private static int findDepth(Node root) {
        int d=0;
        while(root != null){
            d++;
            root = root.left;
        }
        return d;
    }

    private static boolean isPerfectBinaryTree(Node root, int dept, int level) {
        if(root == null)
            return true;

        if(root.left == null && root.right==null)
            return (dept == level+1);

        if(root.left == null || root.right == null)
            return false;

        return isPerfectBinaryTree(root.left,dept, level+1) && isPerfectBinaryTree(root.right, dept, level+1);
    }
}
