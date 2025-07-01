package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeftRightView {
    /**
                1
              /  \
            2      3
           / \     / \
         4    10  9   10
          \
           5
            \
             6

     leftView = 1,2,4,5,6
     rightView = 1,3,10
     */


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        List list = leftView(root);
        System.out.println(list);
        List list1 = rightView(root);
        System.out.println(list1);
    }

    public static List<Integer> leftView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        recursionLeft(root, 0, res);
        return res;
    }

    private static void recursionLeft(TreeNode root, int level, List<Integer> list) {
        if(root == null)
            return;

        if (list.size() == level)
            list.add(root.key);

        recursionLeft(root.left, level+1, list);
        recursionLeft(root.right, level+1, list);
    }

    public static List<Integer> rightView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        recursionRight(root, 0, res);
        return res;
    }

    private static void recursionRight(TreeNode root, int level, List<Integer> list) {
        if(root == null)
            return;

        if (list.size() == level){
            list.add(root.key);
            recursionRight(root.right, level+1, list);
            recursionRight(root.left, level+1, list);
        }
    }
}
