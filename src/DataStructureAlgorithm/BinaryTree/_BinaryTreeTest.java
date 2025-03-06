package DataStructureAlgorithm.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _BinaryTreeTest {

     /*
                    10
                    /\
                  11  9
                 /\   /\
                7  6 15  8

InOrder print : 7 11 6 10 15 9 8
PreOrder print : 10 11 7 6 9 15 8
PostOrder print : 7 6 11 15 8 9 10
LevelOrder print : 10 11 9 7 6 15 8
*/

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        //inorder(root);
        //levelOrder(root);
        inOrderStack(root);

    }

    private static void inOrderStack(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
             cur = stack.pop();
            System.out.print( cur.key + " ");
            cur = cur.right;
        }

    }

    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            System.out.print(tmp.key + " ");
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
        }
    }

    public static void inorder(Node root){
        if (root!= null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}
