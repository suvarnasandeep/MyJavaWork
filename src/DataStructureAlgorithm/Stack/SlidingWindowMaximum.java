package DataStructureAlgorithm.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 https://takeuforward.org/data-structure/sliding-window-maximum/
 https://www.youtube.com/watch?v=CZQGRp93K4k&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=13
 */
public class SlidingWindowMaximum {

    public static int[] getSlidingWindowMaxBruteforce(int[] arr, int interval){
        int size = arr.length;
        int[] result = new int[size-interval+1];
        for (int i=0; i<=size-interval; i++){
            int max = arr[i];
            for (int j=1; j<interval; j++){
                if(arr[i+j] > max){
                    max = arr[i+j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque< Integer > q = new ArrayDeque< >();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] input = {1,3,-1,-3,5,3,6,7};
        int interval = 3;
        int[] res = getSlidingWindowMaxBruteforce(input, interval);
        print(input, res);

    }

    public static void print(int[] input, int[] res){
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
