package DataStructureAlgorithm.Arrays;

//O(1)
/*The simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this).
And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this).
Each time we get a positive-sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
 */
public class MaxSubArraySum {

    public int getMaxSubArraySum(int[] input){
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int start=0,end=0,s=0;

        for(int i=0; i<=input.length-1; i++){
            max_ending_here = max_ending_here + input[i];

            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start=s;
                end=i;
            }
            if(max_ending_here <0){
                max_ending_here=0;
                s = i+1;
            }
        }

        System.out.println("start : " +start + " end : " + end);
        return max_so_far;
    }

    /*
    Kadane’s algorithm Explanation
    -------------------------------
    Lets take the example:
    {-2, -3, 4, -1, -2, 1, 5, -3}

    max_so_far = INT_MIN
    max_ending_here = 0

    for i=0,  a[0] =  -2
    max_ending_here = max_ending_here + (-2)
    Set max_ending_here = 0 because max_ending_here < 0

    for i=1,  a[1] =  -3
    max_ending_here = max_ending_here + (-3)
    Set max_ending_here = 0 because max_ending_here < 0

    for i=2,  a[2] =  4
    max_ending_here = max_ending_here + (4)
    max_ending_here = 4
    max_so_far is updated to 4 because max_ending_here greater
    than max_so_far which was 0 till now

    for i=3,  a[3] =  -1
    max_ending_here = max_ending_here + (-1)
    max_ending_here = 3

    for i=4,  a[4] =  -2
    max_ending_here = max_ending_here + (-2)
    max_ending_here = 1

    for i=5,  a[5] =  1
    max_ending_here = max_ending_here + (1)
    max_ending_here = 2

    for i=6,  a[6] =  5
    max_ending_here = max_ending_here + (5)
    max_ending_here = 7
    max_so_far is updated to 7 because max_ending_here is
    greater than max_so_far

    for i=7,  a[7] =  -3
    max_ending_here = max_ending_here + (-3)
    max_ending_here = 4
     */

    public static void main(String[] args) {
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        //int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        //int arr[] = {5,4,-1,7,8};
        MaxSubArraySum obj = new MaxSubArraySum();
        System.out.println(obj.getMaxSubArraySum(arr));
    }
}
