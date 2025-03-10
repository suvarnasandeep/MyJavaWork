package DataStructureAlgorithm.Stack;

public class StackImpUsingLinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public boolean isEmpty(){
        return head == null ? true : false;
    }

    public void push(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        System.out.println("push - " +data);
    }

    public int pop(){

        if(isEmpty()){
            System.out.println("stack is empty");
            return  -999;
        } else {
            int data = head.data;
            head = head.next;
            System.out.println("pop - " + data);
            return data;
        }

    }

    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -999;
        } else {
            System.out.println("peek - " + head.data);
            return  head.data;
        }
    }

    public void printStack(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImpUsingLinkedList s = new StackImpUsingLinkedList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        s.printStack();

        s.pop();
        s.printStack();
        s.peek();
        s.pop();
        s.printStack();
    }
}
