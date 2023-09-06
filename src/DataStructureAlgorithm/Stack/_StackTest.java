package DataStructureAlgorithm.Stack;
//sandeep
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _StackTest {

    public static void main(String[] args) {
        //String[] input = {"aa", "aa", "aa", "aa","aa","bcd", "ab", "ab"};
        String[] input = {"aa","tom", "jerry", "jerry", "tom", "q", "q", "q"};

        System.out.println(delete(input));
    }

    public static int delete(String[] arr){
        Stack<String> s = new Stack<>();

        for(String var : arr){
            if(s.isEmpty()){
                s.push(var);
                continue;
            }
            if(s.peek().equalsIgnoreCase(var)){
                s.pop();
            } else {
                s.push(var);
            }
        }

        return s.size();
    }
}
