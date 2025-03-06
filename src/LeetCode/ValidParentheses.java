package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*******************************************************************************
 *You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 *The input string s is valid if and only if:
 * Every open bracket is closed by the same type of close bracket.
 * Open brackets are closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 *
 * Input: s = "[]"
 * Output: true
 *
 * Input: s = "([{}])"
 * Output: true
 *
 * Input: s = "[(])"
 * Output: false
 */

public class ValidParentheses {

    public static void main(String[] args) {

        System.out.printf("isValid : "  + isValid1("()()[[]()[]()"));

    }


    public static  boolean isValid(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);

            if(map.containsKey(c)){
                if(!stack.isEmpty() && map.get(c).equals(stack.peek())){
                    stack.pop();
                } else{
                    return  false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

    public static boolean isValid1(String s){
        Map<Character, Character > map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                if(!stack.isEmpty() && stack.peek().equals(map.get(c))){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();


    }
}
