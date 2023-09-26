package DataStructureAlgorithm.Arrays;

import java.util.Stack;

//https://studyalgorithms.com/array/hackerrank-equal-stacks/
public class EqualStack {

    public int getEqualStack(int[] arr1, int[] arr2, int[] arr3){
        int res = 0;

        Stack s1 = new Stack();
        Stack s2 = new Stack();
        Stack s3 = new Stack();

        printInputArray(arr1,arr2,arr3);
        fillStack(arr1,s1,arr2,s2,arr3,s3);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("----------------------------");

        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()){

            int s1H = (int) s1.peek();
            int s2H = (int) s2.peek();
            int s3H = (int) s3.peek();

            if(s1H==s2H && s1H==s3H){
                res = s1H;
                break;
            }

            if(s1H >= s2H && s1H >= s3H){
                s1.pop();
            } else if(s2H >= s1H && s2H >= s3H){
                s2.pop();
            } else if(s3H >= s1H && s3H >= s2H){
                s3.pop();
            }
        }

        return res;
    }


    private void fillStack(int[] arr1, Stack s1, int[] arr2, Stack s2, int[] arr3, Stack s3) {

        for(int i=arr1.length-1; i>=0; i--){
            if(s1.isEmpty()){
                s1.push(arr1[i]);
            } else {
                s1.push((int)s1.peek()+arr1[i]);
            }

        }

        for(int j=arr2.length-1; j>=0; j--){
            if(s2.isEmpty()){
                s2.push(arr2[j]);
            } else {
                s2.push((int) s2.peek() + arr2[j]);
            }
        }
        for(int k =arr3.length-1;k>=0;k--){
            if(s3.isEmpty()){
                s3.push(arr3[k]);
            }else {
                s3.push((int) s3.peek() + arr3[k]);
            }
        }
    }

    private void printInputArray(int[] arr1, int[] arr2, int[] arr3) {
        System.out.print("[ ");
        for(int i : arr1)
            System.out.print(i + " ");

        System.out.println("]");
        System.out.print("[ ");
        for(int i : arr2)
            System.out.print(i + " ");

        System.out.println("]");
        System.out.print("[ ");
        for(int i : arr3)
            System.out.print(i + " ");

        System.out.println("]");
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,1,1,2};
        int[] arr2 = {4,3, 3};
        int[] arr3 = {1,1,4,2};

        EqualStack s = new EqualStack();
        System.out.println("Equal stack : " + s.getEqualStack(arr1,arr2,arr3));

    }
}
