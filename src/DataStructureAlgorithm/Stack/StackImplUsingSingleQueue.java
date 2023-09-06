package DataStructureAlgorithm.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplUsingSingleQueue {

    Queue q = new LinkedList();

    public void push(int data){

        int size = q.size();

        q.add(data);
        System.out.println("push - " + data);
        for(int i=0; i<size; i++){
            int x = (int) q.remove();
            q.add(x);
        }
    }

    public void pop(){
        System.out.println("pop - " + q.remove());
    }

    public void print(){
        System.out.println(q);
    }

    public static void main(String[] args) {
        StackImplUsingSingleQueue s = new StackImplUsingSingleQueue();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.print();

        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
}
