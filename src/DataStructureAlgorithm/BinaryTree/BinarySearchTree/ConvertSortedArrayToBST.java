package DataStructureAlgorithm.BinaryTree.BinarySearchTree;

public class ConvertSortedArrayToBST {

    public static void convertSortedArrayToBST(){
        int arr[] = new int[]{2, 3, 4, 5, 6, 8,10};
        int n = arr.length;
        Node root = convertToBST(arr, 0, n - 1);

        inOrderPrint(root);
    }
    public static Node convertToBST(int[] arr, int start, int end){

        if(start > end){
            return null;
        }
        int mid = (start + end) /2;
        Node node = new Node(arr[mid]);
        node.left = convertToBST(arr, start, mid-1);
        node.right = convertToBST(arr, mid+1, end);

        return node;
    }

    public static void inOrderPrint(Node root){
        if(root!=null){
            System.out.print(root.data + " ");
            inOrderPrint(root.left);

            inOrderPrint(root.right);

        }
    }
}
