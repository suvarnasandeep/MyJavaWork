package DataStructureAlgorithm.Stack;

//import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        //stackImpUsingArray();
        //stackImpUsingLinkedList();
        //queueUsingStack();
        stackWithGetMin();
        //stackWithGetMin1();
        //twoStackUsingArray();
        //stackUsingQueue();
        //stackUsingSingleQueue();
        //stockSpanProblem();
        //nextGreaterElement();
        //numberOfNextGreaterElement();
        //reverseNUmber();

        //deleteConsecutive();
    }

    private static void deleteConsecutive() {
        DeleteConsecutiveSameWord o = new DeleteConsecutiveSameWord();

        String[] input = {"aa", "aa", "aa", "aa","aa","bcd", "ab", "ab"};
        //String[] input = {"tom", "jerry", "jerry", "tom"};

        System.out.println(o.deleteConsecutiveWord(input));
    }

    private static void reverseNUmber() {
        ReverseNumber r = new ReverseNumber();
        int input = 123456;
        System.out.println(input + " -- " +r.reverseNumber(input));
    }

    private static void numberOfNextGreaterElement() {

        NumberOfNextGreaterElements obj = new NumberOfNextGreaterElements();

        int[] input = {3,4,2,7,5,8,10,6};
        int index = 5;

        System.out.print("[ ");
        for(int a : input){
            System.out.print(a + " ");
        }
        System.out.println(" ]");
        System.out.println("index : "+ index + " Num NGE : " + obj.getNumberOfGreaterElementsBruteForce(input, index));
    }

    private static void nextGreaterElement() {
        NextGreaterElement ele = new NextGreaterElement();

        //int[] input = {13,7,6,12};
        int[] input = {4,12,5,3,1,2,5,3,1,2,4,6};
        int[] res = ele.nextGreaterElementBruteForce(input);

        System.out.print("[ ");
        for(int a : input){
            System.out.print(a + " ");
        }
        System.out.println(" ]");

        System.out.print("[ ");
        for(int a : res){
            System.out.print(a + " ");
        }
        System.out.println(" ]");

        System.out.println("---------------------------");

        int[] res1 = ele.nextGreaterElement(input);

        System.out.print("[ ");
        for(int a : input){
            System.out.print(a + " ");
        }
        System.out.println(" ]");

        System.out.print("[ ");
        for(int a : res1){
            System.out.print(a + " ");
        }
        System.out.println(" ]");
    }

    private static void stockSpanProblem() {

        StockSpanProblem s = new StockSpanProblem();
        int [] data = {100, 80,60,70,60,75,85};
        int[] arr = s.stockSpanBruteForce(data);

        System.out.print("[ ");
        for(int i=0; i< data.length; i++){
            System.out.print( arr[i] + " ");
        }
        System.out.println("]");

        System.out.println("----------------------------");
        int[] arr1 = s.stockSpan(data);

        System.out.print("[ ");
        for(int i=0; i< data.length; i++){
            System.out.print( arr1[i] + " ");
        }
        System.out.println("]");
    }

    private static void stackUsingSingleQueue() {
        StackUsingSingleQueue s = new StackUsingSingleQueue();

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

    private static void stackUsingQueue() {

        StackUsingQueue s = new StackUsingQueue();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        s.print();

        s.pop();
        s.pop();
        s.pop();
        s.print();
    }

    private static void twoStackUsingArray() {
        TwoStackUsingArray s = new TwoStackUsingArray(6);

        s.push1(1);
        s.push1(2);
        s.push1(3);

        s.push2(11);
        s.push2(12);
        s.push2(13);
        s.push2(21);

        System.out.println("pop - " + s.pop1());
        System.out.println("pop - " + s.pop1());
        System.out.println("pop - " + s.pop1());
        System.out.println("pop - " + s.pop1());

        System.out.println("pop - " + s.pop2());
        System.out.println("pop - " + s.pop2());
        System.out.println("pop - " + s.pop2());
        System.out.println("pop - " + s.pop2());
        System.out.println("pop - " + s.pop2());

    }

    private static void stackImpUsingArray() {
        StackImpUsingArray stack = new StackImpUsingArray(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("peek is - "+ stack.peek());
        stack.push(5);
        stack.printStack();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();
        stack.pop();
        System.out.println("peek is - "+ stack.peek());
        stack.pop();

        stack.pop();
    }

    private static void stackImpUsingLinkedList() {
        StackImpUsingLinkedList s = new StackImpUsingLinkedList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        s.printStack();

        s.pop();
        s.printStack();
        s.peek();
        s.pop();
        s.printStack();
    }

    private static void queueUsingStack() {
        QueueUsingStack q = new QueueUsingStack();
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

    private static void stackWithGetMin() {
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

    private static void stackWithGetMin1() {
        StackWithGetMin1 s = new StackWithGetMin1();
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(1);
        s.push(1);
        s.push(-1);

        System.out.println("[3 5 2 1 1 -1]");
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());
    }
}
