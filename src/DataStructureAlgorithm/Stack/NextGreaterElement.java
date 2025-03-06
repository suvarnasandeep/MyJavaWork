package DataStructureAlgorithm.Stack;

import java.util.Stack;
/*
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=7
https://takeuforward.org/data-structure/next-greater-element-using-stack/
 */
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

    public int[] nextGreaterElementsCircular(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack < Integer > st = new Stack < > ();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty() == false) nge[i] = st.peek();
                else nge[i] = -1;
            }

            st.push(nums[i % n]);
        }
        return nge;
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

    public static void main(String[] args) {
        NextGreaterElement ele = new NextGreaterElement();

        int[] input = {13,7,6,12};
        //int[] input = {4,12,5,3,1,2,5,3,1,2,4,6};
        //int[] res = ele.nextGreaterElementBruteForce(input);

        int[] res1 = ele.nextGreaterElement(input);

        ele.print(input, res1);

        int[] res = ele.nextGreaterElementsCircular(input);
        ele.print(input, res);
    }

    public void print(int[] input, int[] res){
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
}
