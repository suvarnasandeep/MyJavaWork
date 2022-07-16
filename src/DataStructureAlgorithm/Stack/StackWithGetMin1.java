package Stack;

import java.util.Stack;

//time complexity O(1)
//space complexity O(1)

//push - 2*x - min
//pop - 2*min - y
public class StackWithGetMin1 {

    Stack stack = new Stack();
    int minEl;

    public void push(int data){
        if(stack.isEmpty()){
            stack.push(data);
            minEl = data;
        } else {
            if(data >= minEl){
                stack.push(data);
            } else {
                int i = 2*data - minEl;
                stack.push(i);
                minEl = data;
            }
        }
    }

    public void pop(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty!");
        } else {
            int i = (int) stack.pop();
            if(i >= minEl){
                System.out.println("pop - " + i);
            } else {
                System.out.println("pop - " + minEl);
                minEl = 2*minEl - i;
            }
        }
    }

    public void printStack(){
        System.out.println(stack);
    }

    public int getMin(){
        return minEl;
    }
}
