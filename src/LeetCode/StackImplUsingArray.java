package LeetCode;

public class StackImplUsingArray {

    int[] arr;
    int size;
    int top;

    StackImplUsingArray(int size){
        this.size = size;
        this.top = 0;
        arr = new int[size];
    }

    public static void main(String[] args) {
        StackImplUsingArray stack = new StackImplUsingArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.top);
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }

    public void push(int data){
        if(isFUll()){
            System.out.println("stack is full");
            return;
        }
        arr[top++] = data;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return arr[--top];
    }

    public int top(){
        if (isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return arr[top];
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFUll(){
        return top == size;
    }


}
