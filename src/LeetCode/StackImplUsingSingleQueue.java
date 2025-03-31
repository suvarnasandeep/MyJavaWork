package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplUsingSingleQueue {

    Queue q = new LinkedList();
    int qSize = 0;

    public static void main(String[] args) {
        StackImplUsingSingleQueue stack = new StackImplUsingSingleQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }

    public void push(int data){
        int size = q.size();

        q.add(data);
        qSize++;
        System.out.println("push - " + data);
        for(int i=0; i<size; i++){
            int x = (int) q.remove();
            q.add(x);
        }
    }

    public int pop(){
        qSize--;
        return (int) q.poll();
    }

    public int top(){
        return (int) q.peek();
    }

    public  int size(){
        return qSize;
    }
}
