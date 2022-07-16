package DataStructureAlgorithm.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue q1 = new LinkedList();
    Queue q2 = new LinkedList();


    public void push(int data){
        if(q1.isEmpty()){
            q1.add(data);
        } else {
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
            q1.add(data);
            while (!q2.isEmpty()){
                q1.add(q2.poll());
            }
        }
    }

    public void pop(){
        System.out.println("pop - " + q1.poll());
    }

    public void print(){
        System.out.println(q1);
    }

}
