package DataStructureAlgorithm.BinaryTree.BinarySearchTree;

public class _BinarySearchTreeTest {
    static Node root;

    public static void main(String[] args) {
        insert(40);
        insert(20);
        insert(10);
        insert(30);
        insert(60);
        insert(50);
        insert(70);

        inOrder(root);
        preOrder(root);
    }

    public static void insert(int data){
        Node node = new Node(data);
        if(root == null){
            root =node;
            return;
        }

        Node cur = root;
        Node par = null;
        while(true){
            par = cur;
            if(data < cur.data){
                cur = cur.left;
                if(cur == null){
                    par.left = node;
                    return;
                }
            } else {
                cur = cur.right;
                if(cur == null){
                    par.right = node;
                    return;
                }
            }
        }
    }

    public void insert1(int data){
        Node node = new Node(data);
        if(root==null){
            root = node;
            return;
        }
        Node cur = root;
        Node par = null;
        while(true){
            par = cur;
            if(data<cur.data){
                cur = cur.left;
                if(cur==null){
                    par.left=node;
                    return;
                }
            }else{
                cur = cur.right;
                if(cur==null){
                    par.right=node;
                    return;
                }
            }
        }

    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }
}
