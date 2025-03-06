package DataStructureAlgorithm.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _StackTest {
    int top;
    int size;
    Integer[] arr;

    public _StackTest(int size){
        this.size=size;
        this.top = -1;
        this.arr = new Integer[size];
    }

    public void size(){
        int size = top;
        System.out.println("size : " + ++size);
    }

    public void top(){
        if (!isEmpty()){
            System.out.println("top :" + arr[top]);
        } else {
            System.out.println("stack is empty");
        }
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size-1;
    }

    public void push(int val){
        if(isFull()){
            System.out.println("stack is full");
        } else {
            arr[++top] = val;
            System.out.println("push : " + val);
        }
    }

    public void pop(){
        if (isEmpty()){
            System.out.println("stack is empty");
        } else {
            System.out.println("pop : " + arr[top--]);
        }
    }

    public static void main(String[] args) {
        _StackTest stack = new _StackTest(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.size();
        stack.pop();
        stack.pop();
        stack.top();
        stack.pop();
        stack.top();
        stack.pop();
        stack.top();
        stack.pop();
        stack.top();
        stack.size();

    }
}
