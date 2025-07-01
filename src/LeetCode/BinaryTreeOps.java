package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOps {
    /**
            10
            /\
          11  9
          /\   /\
         7  6 15  8
        /
       55

     inOrder   = 55,7,11,6,10,15,9,8
     preOrder  = 10,11,7,55,6,9,15,8
     postOrder = 55,7,6,11,15,8,9,10
    */
    public static void main(String[] args) {
        //construct binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(55);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        System.out.println("inOrder : ");
        inOrder(root);
        System.out.println();
        System.out.println("preOrder : ");
        preOrder(root);
        System.out.println();
        System.out.println("postOrder : ");
        postOrder(root);
        System.out.println();
        System.out.println("levelOrder : ");
        levelOrder(root);
    }

    //Inorder (Left, Root, Right)
    public static void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print( root.key + " ");
        inOrder(root.right);
    }

    //Preorder (Root, Left, Right)
    public static void preOrder(TreeNode root){
        if(root == null)
            return;
        System.out.print( root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Postorder (Left, Right, Root)
    public static void postOrder(TreeNode root){
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print( root.key + " ");
    }

    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            System.out.print(tmp.key + " ");
            if (tmp.left != null)
                queue.add(tmp.left);
            if (tmp.right != null)
                queue.add(tmp.right);
        }
    }
}
