package DataStructureAlgorithm.Stack;

import java.util.Stack;

public class ValidParenthesis {

    /*
    input - []{()}      -> true
    input - {[[()]]     -> false
    input - [()[{()}]]  -> true
    input - [(()]       -> false
    input - {()         -> false
    input - ]{}         -> false
     */

    public static void main(String[] args) {
        ValidParenthesis obj = new ValidParenthesis();
        String input = "[[[]]";
        System.out.println(obj.validateParentheses(input));
    }

    public boolean validateParentheses(String input){
        Stack<Character> s = new Stack();

        for (int i=0; i<input.length(); i++){
            Character c = input.charAt(i);
            if(c =='[' || c == '{' || c == '('){
                s.push(c);
            } else {
                if(s.isEmpty()) return false;
                Character cc = s.pop();
                if((cc == '[' && c == ']') || (cc == '{' && c == '}') || (cc == '(' && c == ')')){
                    continue;
                } else {
                    return false;
                }
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }
}
