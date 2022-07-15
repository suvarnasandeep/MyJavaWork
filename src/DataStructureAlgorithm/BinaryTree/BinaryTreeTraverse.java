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

    public static void constructTree(){
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left=new Node(7);
        root.left.right = new Node(6);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

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

    //inOrder using stack
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
}
