package Stack;

import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] data){
        int size = data.length;
        Stack stack = new Stack();
        int[] res = new int[size];

        for(int i = size-1; i>=0; i--){
            int val = data[i];
            if(stack.isEmpty()){
                res[i] = -1;
                stack.push(val);
            } else {
                while(!stack.isEmpty()){
                    if(val > (int)stack.peek()){
                        stack.pop();
                    } else {
                        res[i] = (int)stack.peek();
                        stack.push(val);
                        break;
                    }
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                    stack.push(val);
                }
            }
        }
        return  res;
    }

    public int[] nextGreaterElementBruteForce(int[] data){
        int[] res = new int[data.length];

        for(int i = 0; i<data.length; i++){
            int curVal = data[i];
            int out = -1;
            for(int j=i+1; j<data.length; j++){
                if(data[i] <= data[j]){
                    out = data[j];
                    break;
                }
            }
            res[i] = out;
        }

        return res;
    }
}
