package LeetCode;

import java.util.Stack;

public class StackWithGetMin extends Stack {
    Stack<Integer> stack;

    public StackWithGetMin(){
        super();
        stack = new Stack<>();
    }

    public void push(int data){
        super.push(data);

        if(stack.isEmpty() || data <= stack.peek())
            stack.push(data);
    }

    public Object pop(){
        int pop = (int) super.pop();

        if(pop == stack.peek())
            stack.pop();
        return pop;
    }

    public int getMin(){
        if(stack.isEmpty())
            return -999;
        return stack.peek();
    }

    public static void main(String[] args) {
        StackWithGetMin s = new StackWithGetMin();

        s.push(10);
        s.push(29);
        s.push(9);
        s.push(21);
        s.push(8);
        s.push(60);

        System.out.println(s);
        s.pop();
        System.out.println(s);
        System.out.println("min value is - " + s.getMin());
        s.pop();
        System.out.println(s);
        System.out.println("min value is - " + s.getMin());

        s.pop();
        System.out.println(s);
        System.out.println("min value is - " +  s.getMin());

        s.pop();
        System.out.println(s);
        System.out.println("min value is - " +  s.getMin());

        s.pop();
        System.out.println(s);
        System.out.println("min value is - " +  s.getMin());

        s.pop();
        System.out.println(s);
        System.out.println("min value is - " +  s.getMin());
    }


}
