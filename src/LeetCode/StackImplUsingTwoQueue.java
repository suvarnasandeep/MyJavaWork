package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplUsingTwoQueue {

    int size = 0;
    Queue q1 = new LinkedList<>();
    Queue q2 = new LinkedList<>();


    public static void main(String[] args) {
        StackImplUsingTwoQueue stack = new StackImplUsingTwoQueue();
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

    private void push(int i) {
       while (!q1.isEmpty()){
           q2.add(q1.poll());
       }
       q1.add(i);
       size++;
       while (!q2.isEmpty()){
           q1.add(q2.poll());
       }
    }


    private int pop() {
        int pop = (int) q1.poll();
        size--;
        return pop;
    }

    private int top() {
        return (int) q1.peek();
    }

    private int size() {
        return size;
    }
}
