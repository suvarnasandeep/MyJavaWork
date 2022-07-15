package DataStructureAlgorithm.BinaryTree.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TestMain {

    static class Node {
        int val;
        Node right, left;

        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
    }

    public static void inOrder(Node root){

        if(root == null)
            return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if(root == null)
            return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node tmpNode = queue.poll();
            System.out.print(tmpNode.val + " ");

            if(tmpNode.left != null){
                queue.add(tmpNode.left);
            }
            if(tmpNode.right != null){
                queue.add(tmpNode.right);
            }
        }
    }
}
