package DataStructureAlgorithm.BinaryTree;

public class FullBinaryTree {
    /*
    A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.
                18
              /     \
             40       30
                       /  \
                     100   40
    */
    public static void fullBinaryTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right= new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);

        if(isFullBinaryTree(root)){
            System.out.println("The tree is full binary tree");
        } else {
            System.out.println("The tree is not a full binary tree");
        }
    }

    private static boolean isFullBinaryTree(Node root) {
        if(root == null)
            return true;

        if(root.left==null && root.right==null)
            return true;

        if(root.left!=null && root.right != null){
            return (isFullBinaryTree(root.left) && isFullBinaryTree(root.right));
        }

        return false;
    }
}
