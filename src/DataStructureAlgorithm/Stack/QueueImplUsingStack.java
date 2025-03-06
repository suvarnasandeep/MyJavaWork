package DataStructureAlgorithm.Stack;

import java.util.Stack;

public class QueueImplUsingStack {

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public void enQueue(int i) {

        if(stack1.isEmpty()){
            stack1.push(i);
            System.out.println("enqueue - " + i);
        } else {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(i);
            System.out.println("enQueue - " + i);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public void deQueue() {
        if(stack1.isEmpty()){
            System.out.println("queue is empty!!!");
        } else {
            System.out.println("deQueue - " + stack1.pop());
        }
    }

    public void printQueue() {
        System.out.println("queue is - " +stack1);

    }

    public static void main(String[] args) {
        QueueImplUsingStack q = new QueueImplUsingStack();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        q.printQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.printQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
    }
}
