package DataStructureAlgorithm.Stack;

import java.util.Stack;

public class ReversePolish {
    public static void main(String[] args) {
        /*
        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
         */
        String[] input = new String[]{"2", "1", "+", "3", "*"};

        reversePolish(input);
    }

    private static void reversePolish(String[] input) {

        Stack<String> stack = new Stack<>();
        String operand = "+-*/";

        for(String str : input){
            if(!operand.contains(str)){
                stack.push(str);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (str){
                    case "+":
                        stack.push(Integer.toString(a + b));
                        break;
                    case "-":
                        stack.push(Integer.toString(b - a));
                        break;
                    case "*":
                        stack.push(Integer.toString(a * b));
                        break;
                    case "/":
                        stack.push(Integer.toString(b / a));
                        break;
                }
            }

        }
        System.out.println(stack.pop());
    }
}
