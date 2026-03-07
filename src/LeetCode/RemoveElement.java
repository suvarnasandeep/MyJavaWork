package LeetCode;

public class RemoveElement {
    /*
    Example 1:

    Input: nums = [3,2,2,3], val = 3
    Output: 2, nums = [2,2,_,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Example 2:
    Input: nums = [0,1,2,2,3,0,4,2], val = 2
    Output: 5, nums = [0,1,4,0,3,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
     */
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        System.out.println(removeElement(arr, 3));

        int[] arr1 = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr1, 2));
    }

    public static int removeElement(int[] arr, int val){
        int pt1 = 0;
        int pt2 = 0;

        while (pt1 < arr.length){
            if(arr[pt1] != val){
                int tmp = arr[pt1];
                arr[pt1] = arr[pt2];
                arr[pt2] = tmp;
                pt2++;

            }
            pt1++;
        }

        return pt2;

    }
}
