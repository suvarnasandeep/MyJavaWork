package DataStructureAlgorithm.Stack;
//sandeep
import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        int [] data = {100, 80,60,70,60,75,85};
        System.out.println("[1 1 1 2 1 4 6 ]");
        System.out.println("----------------------------");
        int[] arr1 = stockSpan(data);

        System.out.print("[ ");
        for(int i=0; i< data.length; i++){
            System.out.print( arr1[i] + " ");
        }
        System.out.println("]");
    }

    private static int[] stockSpan(int[] data) {
        int[] span = new int[data.length];

        Stack stack = new Stack();

        span[0] = 1;
        stack.push(0);

        for(int i=1; i<data.length; i++){
            while(!stack.isEmpty() &&
                    data[i] >= data[(int)stack.peek()]){
                stack.pop();
            }

            span[i] = (i - (int)stack.peek());
            stack.push(i);

        }

        return span;
    }
}
