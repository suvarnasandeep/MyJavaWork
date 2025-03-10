package DataStructureAlgorithm.Stack;

public class StackImpUsingArray {

    private Integer[] arr;
    private int top;
    private int size;

    public StackImpUsingArray(int size){
        this.size = size;
        top = -1;
        arr = new Integer[size];
    }

    public void push(Integer data){

        if(isFull()){
            System.out.println("stack is full");
            return;
        } else {
            arr[++top] = data;
            System.out.println("push - " + data);
        }

    }

    private boolean isFull() {
        return top+1 == size;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("stack is empty");

        } else {
            System.out.println( "pop - " + arr[top--]);
        }
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void printStack(){
        System.out.print("[ ");
        for(int i = top; i > -1; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public int peek(){
        return arr[top];
    }

    public static void main(String[] args) {
        StackImpUsingArray stack = new StackImpUsingArray(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("peek is - "+ stack.peek());
        stack.push(5);
        stack.printStack();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();
        stack.pop();
        System.out.println("peek is - "+ stack.peek());
        stack.pop();

        stack.pop();
    }
}
