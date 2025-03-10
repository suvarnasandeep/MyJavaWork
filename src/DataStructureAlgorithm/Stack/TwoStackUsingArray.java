package DataStructureAlgorithm.Stack;

public class TwoStackUsingArray {

    int size;
    Integer[] arr;
    int top1,top2;

    public TwoStackUsingArray(int size){
        this.size = size;
        arr = new Integer[size];
        top1 = -1;
        top2 = size-1;
    }

    public void push1(int data){
        if(top1 == top2){
            System.out.println("stack1 is full");
        } else {
            arr[++top1] = data;
            System.out.println("push1 - " + data);
        }
    }

    public void push2(int data){
        if(top1 == top2){
            System.out.println("stack2 is full");
        } else {
            arr[top2--] = data;
            System.out.println("push2 - " + data);
        }
    }

    public int pop1(){
        if(top1 < 0 ){
            System.out.println("stack1 is empty");
            return -999;
        }
        return arr[top1--];
    }

    public int pop2(){
        if(top2 >= size -1){
            System.out.println("stack2 is empty");
            return -999;
        }
        return arr[++top2];
    }


    /*public void printStack(){
        System.out.println(arr);
    }*/

    public static void main(String[] args) {
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
}
