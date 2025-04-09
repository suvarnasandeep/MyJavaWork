package LeetCode;

import java.util.Stack;

public class NexGreaterElement {

    public static void main(String[] args) {
        //int[] input = {13,7,6,12};
        int[] input = {4,12,5,3,1,2,5,3,1,2,4,6};

        print(input, nextGreaterElement1(input));
        print(input, nextGreaterElement(input));
        print(input, nextGreaterElementCircular(input));

    }

    public static int[] nextGreaterElement1(int[] arr){
        int len = arr.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i= len-1; i>=0; i--){
            if (stack.isEmpty()){
                res[i] = -1;
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty()){
                    int val = arr[i];
                    if(val >= stack.peek()){
                        stack.pop();
                    } else {
                        res[i] = stack.peek();
                        stack.push(val);
                        break;
                    }
                }
                if (stack.isEmpty()){
                    res[i] = -1;
                    stack.push(arr[i]);
                }
            }
        }
        return res;
    }

    public static int[] nextGreaterElement(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i= arr.length-1; i >=0; i--){
            while (!stack.isEmpty() && arr[i] >= stack.peek()){
                stack.pop();
            }

            if (!stack.isEmpty()){
                res[i] = stack.peek();
            } else {
                res[i] = -1;
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static int[] nextGreaterElementCircular(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;

        for (int i= 2 * len-1; i >=0; i--){
            while (!stack.isEmpty() && arr[i%len] >= stack.peek()){
                stack.pop();
            }

            if(i < len){
                if (!stack.isEmpty()){
                    res[i] = stack.peek();
                } else {
                    res[i] = -1;
                }
            }

            stack.push(arr[i%len]);
        }
        return res;
    }

    public static void print(int[] input, int[] res) {
        System.out.print("[ ");
        for (int a : input) {
            System.out.print(a + " ");
        }
        System.out.println(" ]");

        System.out.print("[ ");
        for (int a : res) {
            System.out.print(a + " ");
        }
        System.out.println(" ]");
    }
}
