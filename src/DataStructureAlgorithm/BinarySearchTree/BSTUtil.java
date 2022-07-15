package DataStructureAlgorithm.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTUtil {
    static Node root;
    static int height = -1;
/*
    	 40
    	/  \
      20    60
      /\    /\
    10  30 50 70
                \
                 80

    preorder  : 40 20 10 30 60 50 70	/__
    inorder	: 10 20 30 40 50 60 70	/\
    postorder	: 10 30 20 50 70 60 40	__\
    levelorder	: 40 20 60 10 30 50 70
*/
    public static void constructBST() {
        insert(40);
        insert(20);
        insert(10);
        insert(30);
        insert(60);
        insert(50);
        insert(70);
        insert(80);

        traverseBST();
    }

    public static void traverseBST() {
        System.out.print("BST PreOrder Rec   : ");
        preOrderRec(root);
        System.out.println();
        System.out.print("BST PreOrder Itr   : ");
        preOrderItr(root);
        System.out.println();
        System.out.print("BST InOrder Rec    : ");
        inOrderRec(root);
        System.out.println();
        System.out.print("BST InOrder Itr    : ");
        inOrderItr(root);
        System.out.println();
        System.out.print("BST PostOrder Rec  : ");
        postOrderRec(root);
        System.out.println();
        System.out.print("BST PostOrder Itr  : ");
        postOrderItr(root);
        System.out.println();
        System.out.print("BST levelOrder Rec : ");
        levelOrderRec(root);
        System.out.println();
        System.out.print("BST levelOrder Itr : ");
        levelOrder(root);

        System.out.println();
        findMax();

        findMin();

        System.out.println("Height from root Node : " + findHeight(root));

        System.out.println("Height from root Node ITR: " + findHeightITR(root));

        int node = 80;
        System.out.println("Height from "+ node + " node : " + findHeight(root, node));

        System.out.println("Depth from "+ node + "  node : " + findDepth(root, node));
    }

    public static void insert(int data) {
        Node node = new Node(data);

        if (root == null) {
            root = node;
            return;
        }

        Node curr = root;
        Node parent = null;

        while (true) {
            parent = curr;
            if (data < curr.data) {
                curr = curr.left;
                if (curr == null) {
                    parent.left = node;
                    return;
                }
            } else {
                curr = curr.right;
                if (curr == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    //preorder recursion
    public static void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(" " + root.data);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    //preorder iteration
    public static void preOrderItr(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(" " + n.data);

            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
    }

    //Inorder recursion
    public static void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(" " + root.data);
            inOrderRec(root.right);
        }
    }

    //Inorder iteration
    public static void inOrderItr(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node s = stack.pop();
                System.out.print(" " + s.data);
                curr = s.right;
            }
        }
    }

    //Postorder recursion
    public static void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(" " + root.data);
        }
    }

    //Postorder iteration
    public static void postOrderItr(Node root) {
        // Create two stacks
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if (root == null)
            return;

        // push root to first stack
        s1.push(root);

        // Run while first stack is not empty
        while (!s1.isEmpty()) {
            // Pop an item from s1 and push it to s2
            Node temp = s1.pop();
            s2.push(temp);

            // Push left and right children of
            // removed item to s1
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        // Print all elements of second stack
        while (!s2.isEmpty()) {
            Node temp = s2.pop();
            System.out.print(" " + temp.data);
        }
    }

    public static void levelOrderRec(Node root) {

        int depth = height(root);

        for (int i = 1; i <= depth; i++) {
            printLevelOrder(root, i);
        }
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(" " + node.data);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //find max
    public static void findMax() {
        if (root == null) {
            return;
        }

        Node node = root;

        while (node.right != null) {
            node = node.right;
        }
        System.out.println("Max data : " + node.data);
    }

    //find min
    public static void findMin() {
        if (root == null) {
            return;
        }
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }

        System.out.println("Min data : " + node.data);
    }

    public static void printLevelOrder(Node root, int i) {

        if (root == null) {
            return;
        }
        if (i == 1) {
            System.out.print(" " + root.data);
        } else {
            printLevelOrder(root.left, i - 1);
            printLevelOrder(root.right, i - 1);
        }

    }

    public static int height(Node root) {

        if (root == null) {
            return 0;
        } else {
            int ldepth = height(root.left);
            int rdepth = height(root.right);

            if (ldepth > rdepth) {
                return ldepth + 1;
            } else {
                return rdepth + 1;
            }
        }
    }

    public static void printBST(Node root) {
        System.out.print("BST InOrder    : ");
        inOrderRec(root);
        System.out.println();

        System.out.print("BST PreOrder   : ");
        preOrderRec(root);
        System.out.println();

        System.out.print("BST PostOrder  : ");
        postOrderRec(root);
        System.out.println();

        System.out.print("BST levelOrder : ");
        levelOrder(root);


    }

    //find height
    public static int findHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int ldepth = findHeight(node.left);
            int rdepth = findHeight(node.right);

            return Math.max(ldepth,rdepth) + 1;
        }
    }

    public static int findHeightITR(Node node) {
        if(node == null){
            return 0;
        }
        int height = 0;
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        while(!queue.isEmpty()){
            height++;
            int size = queue.size();
            for(int i = 0; i<size; i++){
                Node n = queue.poll();
                if(n.left != null){
                    queue.add(n.left);
                }
                if(n.right != null){
                    queue.add(n.right);
                }
            }
        }
        return height;
    }

    private static int findHeight(Node root, int node) {
        getHeight(root, node);
        return height;
    }

    private static int getHeight(Node root, int node) {
        if(root == null)
            return 0;

        int lh = getHeight(root.left, node);
        int rh = getHeight(root.right, node);

        int ans = Math.max(lh,rh) + 1;

        if(root.data == node)
            height = ans;

        return ans;

    }

    private static int findDepth(Node root, int node) {
        if(root == null)
            return -1;

        int dist = 0;
        if(root.data == node
        || (dist = findDepth(root.left,node)) >= 0
        || (dist = findDepth(root.right, node)) >=0){
           return dist+1;
        }
        return dist;
    }


}
