package DataStructureAlgorithm.BinaryTree.BinarySearchTree;

import java.util.Stack;

public class BSTConstructFromPreOrder {

    /*
    Following is a stack based iterative solution that works in O(n) time.

    1.Create an empty stack.
    2.Make the first value as root. Push it to the stack.
    3.Keep on popping while the stack is not empty and the next value is greater than stack’s top value. Make this value as the right child of the last popped node. Push the new node to the stack.
    4.If the next value is less than the stack’s top value, make this value as the left child of the stack’s top node. Push the new node to the stack.
    5.Repeat steps 2 and 3 until there are items remaining in pre[].
     */
    public static void ConstructBST() {
        int[] arr = {10,5,1,7,40,50};
        Node root = ConstructBSTFromPreOrder(arr);
        System.out.println("Inorder traverse is :");
        printInOrder(root);
        System.out.println();
        System.out.println("PostOrder traverse is :");
        printpostOrder(root);
    }

    public static Node ConstructBSTFromPreOrder(int[] arr){
        Node root = new Node(arr[0]);
        int size = arr.length;
        Stack<Node> s = new Stack<>();

        s.push(root);

        for(int i=1; i<size; i++){
            Node tmp = null;

            while(!s.isEmpty() && arr[i] > s.peek().data){
                tmp = s.pop();
            }

            if(tmp != null){
                tmp.right = new Node(arr[i]);
                s.push(tmp.right);
            } else {
                tmp = s.peek();
                tmp.left = new Node(arr[i]);
                s.push(tmp.left);
            }
        }

        return root;
    }

    private static void printInOrder(Node root) {
        if(root != null){
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    private static void printpostOrder(Node root) {
        if(root != null){
            printpostOrder(root.left);
            printpostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
