package DataStructureAlgorithm.Stack;
//sandeep
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _StackTest {

    public static void main(String[] args) {
        int[] input = {4,12,5,3,1,2,5,3,1,2,4,6}; // 12 -1 6 5 2 5 6 4 2 4 6 -1

        int[] res = nextGreaterElement(input);

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
    }

    //{4,12,5,3,1,2,5,3,1,2,4,6}; // 12 -1 6 5 2 5 6 4 2 4 6 -1
    public static int[] nextGreaterElement(int[] arr){
        int[] ret = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = arr.length-1; i>=0; i--){
            if(stack.isEmpty()){
                ret[i] = -1;
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty()){
                    if(stack.peek() > arr[i]){
                        ret[i] = stack.peek();
                        stack.push(arr[i]);
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if(stack.isEmpty()){
                    ret[i] = -1;
                    stack.push(arr[i]);
                }
            }

        }

        return ret;
    }
    public static int[] nextGreaterElement1(int[] arr){
        int[] ret = new int[arr.length];

        for(int i=0; i<arr.length  ; i++){
            int val = -1;
            for (int j=i+1; j<arr.length; j++ ){
                if(arr[j] > arr[i]) {
                    val = arr[j];
                    break;
                }

            }
            ret[i] =val;
        }

        return ret;
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
