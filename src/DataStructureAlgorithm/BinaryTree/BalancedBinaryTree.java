package DataStructureAlgorithm.BinaryTree;

public class BalancedBinaryTree {
    /*
    -The difference between heights of left subtree and the right subtree is not more than 1
    -the left subtree is balanced
    -the right subtree is balanced

    https://www.tutorialcup.com/leetcode-solutions/balanced-binary-tree-leetcode-solution.htm
    Algorithm(Brute Force):
    Start from the root and keep traversing the binary tree until the root becomes NULL
    Retrieve the height of left and right subtrees using height() function
        If the difference is more than ‘1’:
            return false. As the tree does not satisfy the balance condition
        Check the balance condition for left and right subtrees recursively
    Print the result
    Algorithm(Optimal):
    If the tree is empty, we can say it’s balanced. If not, we can follow other steps:
    Create a helper function to return the “height” of a current subtree, using recursion.
    Height Function will return:
        -1, when it’s an unbalanced tree
        the height otherwise.
    In case a subtree has left or right subtree unbalanced, or their heights differ by more than ‘1’, return -1.
    Otherwise, return the height of this subtree as : 1 + max(left_height, right_height)

     */
    public static void balancedBinaryTree(){
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        //root.right.left = new Node(4);
        //root.right.left.right = new Node(4);
        System.out.println("-------BruteForce Method-------");
        if(isBalancedBrutForce(root))
            System.out.println("Binary Tree is Balanced");
        else
            System.out.println("Binary Tree is Not Balanced");

        System.out.println("-------Optimised Method-------");
        if(isBalanced(root))
            System.out.println("Binary Tree is Balanced");
        else
            System.out.println("Binary Tree is Not Balanced");
    }

    private static boolean isBalanced(Node root) {
        if(root == null)
            return true;
        return (height(root) != -1);
    }

    private static int height(Node root) {
        if(root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;
        return Math.max(l , r) + 1;
    }

    private static boolean isBalancedBrutForce(Node root) {
        if(root == null)
            return true;
        int l = heightBruteForce(root.left) , r = heightBruteForce(root.right);
        if(Math.abs(r - l) > 1)
            return false;
        return isBalancedBrutForce(root.left) && isBalancedBrutForce(root.right);
    }

    private static int heightBruteForce(Node root) {
        if(root == null)
            return 0;
        return Math.max(heightBruteForce(root.left) , heightBruteForce(root.right)) + 1;
    }
}

