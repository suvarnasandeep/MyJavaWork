package DataStructureAlgorithm.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraverse {
    /*
                    10
                    /\
                  11  9
                 /\   /\
                7  6 15  8
*/

    static int DIA = 0;
    public static void constructTree(){
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left=new Node(7);
        root.left.right = new Node(6);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        //root.right.right.left = new Node(44);

        System.out.print("InOrder print : ");
        inOrder(root);
        System.out.println();
        System.out.print("PreOrder print : ");
        preOrder(root);
        System.out.println();
        System.out.print("PostOrder print : ");
        postOrder(root);
        System.out.println();
        System.out.print("LevelOrder print : ");
        levelOrder(root);
        System.out.println();
        System.out.print("Inorder Using Stack : ");
        inOrderUsingStack(root);
        System.out.println();
        System.out.print("PreOrder Using Stack : ");
        preOrderUsingStack(root);
        System.out.println();
        System.out.print("PostOrder Using Stack : ");
        postOrderUsingStack(root);
        System.out.println();
        System.out.println("Search element : "+ searchElement(root, 11));
        System.out.println("Search element : "+ searchElementRec(root, 11));
        levelOrder(root);
        System.out.println();
        insertElement(root, 55);
        levelOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        System.out.println("depth of tree : "+ maxDepth(root));
        System.out.println("depth of tree (Iterative): "+ maxDepthIterative(root));
        System.out.println("is Balanced : " + isBalancedBT(root));
        System.out.println("Max element is (Iterative): "+ findMaxElement(root));
        System.out.println("Max element is (Recursion): "+ findMaxElementRec(root));
        System.out.println("Size of tree : " + numberOfElementInTree(root));
        System.out.println("Size of tree : " + numberOfElementInTreeIterative(root));
        printLevelOrderInReverse(root);

        diameterOfTree(root);
        System.out.println("Diameter of tree : " + DIA);

        System.out.println("Deepest node : " + deepestNode(root));

        System.out.println("Number of full nodes : " + numberOfFullNode(root));

    }

    //Inorder (Left, Root, Right)
    private static void inOrder(Node root) {
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    //Preorder (Root, Left, Right)
    private  static void preOrder(Node root){
        if(root != null){
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //Postorder (Left, Right, Root)
    private  static void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    //level order using queue
    private static void levelOrder(Node root) {
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            System.out.print(tmpNode.key + " ");

            if (tmpNode.left != null) {
                queue.add(tmpNode.left);
            }
            if (tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
        }
    }

    //inOrder using stack - iterative method
    private static void inOrderUsingStack(Node root){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || stack.size() >0){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            System.out.print( cur.key + " ");
            cur = cur.right;
        }
    }

    private static void preOrderUsingStack(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node tmp = stack.pop();
            System.out.print(tmp.key + " ");
            if(tmp.right != null){
                stack.push(tmp.right);
            }
            if (tmp.left != null){
                stack.push(tmp.left);
            }
        }
    }

    private static void postOrderUsingStack(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()){
            Node tmp = s1.pop();
            s2.push(tmp);
            if(tmp.left != null) s1.push(tmp.left);
            if (tmp.right != null) s1.push(tmp.right);
        }

        while (!s2.isEmpty()){
            System.out.print(s2.pop().key + " ");
        }
    }

    private static boolean searchElement(Node root, int num){
        Queue<Node> queue = new LinkedList<>();
        if(root.key == num){
            return true;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp.key == num){
                return true;
            }
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
        }
        return false;
    }

    public static boolean searchElementRec(Node root, int data){
        boolean tmp;
        if(root == null){
            return false;
        } else {
            if(root.key == data) {
                return true;
            } else {
                tmp = searchElementRec(root.left, data);
                if(tmp != true){
                    return tmp;
                } else {
                    return (searchElementRec(root.right, data));
                }
            }
        }
    }

    private static void insertElement(Node root, int num){
        Queue<Node> queue = new LinkedList<>();

        if(root == null){
            root = new Node(num);
        }

        queue.add(root);
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp.left == null) {
                tmp.left = new Node(num);
                return;
            } else if(tmp.right == null) {
                tmp.right = new Node(num);
                return;
            } else {
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
    }

    /*
    max depth from root node is equals to height of the tree
    */
    private static int maxDepth(Node root){
        if(root == null){
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1+ Math.max(lh,rh);
    }

    private static int maxDepthIterative(Node root){
        int height=0;
        Queue<Node> queue = new LinkedList<>();
        if(root == null)
            return 0;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp == null){
                height++;
                if(!queue.isEmpty())
                    queue.add(null);
            } else {
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            }
        }

        return height;
    }

    /*
    The difference between heights of left subtree and the right subtree is not more than 1
     */
    private static boolean isBalancedBT(Node root){
        if(root == null)
            return false;

        System.out.println(height(root));
        return (height(root) != -1);
    }

    private static int height(Node root) {
        if(root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        if(lh == -1 || rh == -1 || Math.abs(lh - rh) > 1){
            return -1;
        }
        return Math.max(lh, rh) +1;
    }

    /*
    using iterative method
     */
    private static int findMaxElement(Node root){
        int max = -1;
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return -1;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp.key > max){
                max = tmp.key;
            }
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if (tmp.right != null){
                queue.add(tmp.right);
            }
        }

        return  max;
    }

    /*
    using recursion
     */

    private static int findMaxElementRec(Node root){
        int root_val,left,right;
        int max = -999;
        if(root!= null){
            root_val = root.key;
            left = findMaxElementRec(root.left);
            right = findMaxElementRec(root.right);
            if(left > max){
                max = left;
            } else {
                max = right;
            }
            if(root_val > max){
                max = root_val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        constructTree();
    }

    public static int numberOfElementInTree(Node root){
        if(root == null){
            return 0;
        } else {
            return (numberOfElementInTree(root.left) +1 + numberOfElementInTree(root.right));
        }
    }

    public static int numberOfElementInTreeIterative(Node root){
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        if(root == null)
            return 0;

        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            count++;
            if(tmp.left != null)
                queue.add(tmp.left);
            if (tmp.right != null)
                queue.add(tmp.right);
        }
        return count;
    }

    public static void printLevelOrderInReverse(Node root){
        System.out.println("Print levelOrder in reverse:");
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        if (root == null)
            return;

        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            System.out.print( tmp.key + " ");
            stack.push(tmp.key);
            if (tmp.left != null)
                queue.add(tmp.left);
            if(tmp.right != null)
                queue.add(tmp.right);
        }
        System.out.println();
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    /*
    longest path between two nodes
     */
    public static int diameterOfTree(Node root){
        int lh,rh;
        if(root == null)
            return 0;
        lh = diameterOfTree(root.left);
        rh = diameterOfTree(root.right);

        DIA = Math.max(DIA, lh+rh);
        return Math.max(lh, rh) +1;
    }

    public static int deepestNode(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node tmp = null;
        while (!queue.isEmpty()){
            tmp = queue.poll();
            if(tmp.left != null)
                queue.add(tmp.left);
            if(tmp.right != null){
                queue.add(tmp.right);
            }
        }
        return tmp.key;
    }

    public static int numberOfFullNode(Node root){
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if (tmp.left != null && tmp.right!= null)
                count++;
            if (tmp.left!= null)
                queue.add(tmp.left);
            if (tmp.right != null)
                queue.add(tmp.right);
        }

        return count;
    }

    public static boolean isSameTree(Node root1, Node root2){
        if(root1 ==null || root2 == null)
            return (root1==root2);

        return (root1.key == root2.key) &&
                isSameTree(root1.left, root2.left) &&
                isSameTree(root1.right, root2.right);
    }
}
