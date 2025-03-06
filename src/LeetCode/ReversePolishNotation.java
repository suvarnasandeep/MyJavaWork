package LeetCode;

import java.util.Stack;

public class ReversePolishNotation {
    /**
     *Input: tokens = ["1","2","+","3","*","4","-"]
     *Output: 5
     *Explanation: ((1 + 2) * 3) - 4 = 5
     */
    public static void main(String[] args) {
        String[] input = {"1","2","+","3","*","4","-"};
        System.out.printf(" "+ getRPN(input));
    }

    public static int getRPN(String[] input){
        int result = 0;
        Stack<String> stack = new Stack<>();
        String operator = "+-*/";

        for(String s : input){
            if(operator.contains(s)){
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (s){
                    case "+":
                        stack.push(String.valueOf(a+b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b-a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a*b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b/a));
                        break;
                }

            } else {
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }



}
