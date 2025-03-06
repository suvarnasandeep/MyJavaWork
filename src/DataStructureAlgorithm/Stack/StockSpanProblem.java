package DataStructureAlgorithm.Stack;

import java.util.Stack;

public class StockSpanProblem {

    public int[] stockSpan(int [] data){
        Stack s = new Stack();
        int[] span = new int[data.length];
        int size = data.length;

        s.push(0);
        span[0] = 1;

        for(int i=1; i<size; i++){
            int val = data[i];
            int peek = (int) s.peek();
            while(!s.isEmpty() && val >= data[peek]){
                s.pop();
                peek = (int) s.peek();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            } else {
                span[i] = i-peek;
            }
            s.push(i);
        }
        return  span;
    }

    public int[] stockSpanBruteForce(int[] data){
        int size = data.length;
        int[] span = new int[size];

        for(int i = size-1; i >= 0; i--){
            int val = data[i];
            int count = 1;
            for(int j = i-1; j>=0; j--){
                int var = data[j];
                if(val < var){
                    break;
                } else {
                    count++;
                }
            }
            span[i] = count;
        }

        return  span;
    }

    public static void main(String[] args) {
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
}
