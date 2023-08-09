package DataStructureAlgorithm.Stack;

import java.util.Stack;

//time complexity O(1)
//space complexity O(n)
public class StackWithGetMin extends Stack {

    Stack stack = new Stack();

    @Override
    public Object push(Object item) {
        super.push(item);

        if(stack.isEmpty()){
            stack.push(item);
        } else {
            int data = (int) stack.peek();
            if(data >= (int)item){
                stack.push(item);
            } else {
                stack.push(data);
            }
        }

        return item;
    }

    @Override
    public synchronized Object pop() {
        stack.pop();
        return super.pop();
    }

    public int getMin(){
        if(stack.isEmpty()){
            System.out.println("stack is empty");
            return -999;
        }
        return (int) stack.peek();
    }

    public static void main(String[] args) {
        StackWithGetMin s = new StackWithGetMin();

        s.push(100);
        s.push(29);
        s.push(25);
        s.push(21);
        s.push(12);
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
