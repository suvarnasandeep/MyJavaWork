package DataStructureAlgorithm.Arrays;

/**
 * Quick select algorithm
 * https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/
 *
 * Time complexity: O(n) , where n = size of the array
 *
 * Space complexity: O(1)
 */

public class KthLargestNumber {
    public static void main(String[] args) {
        int[] input = new int[]{25, 9, 15, 50, 10, 1, 2};
        printInput(input);
        int k = 1;
        int res = kth_largest_number(input, k);
        System.out.println(k + "th largest number - " + res);
    }

    public static int kth_largest_number(int[] arr, int k){
        int kth;
        int len = arr.length;
        int low = 0;
        int high = len-1;

        while(true){
            int partition = getPartition(arr, low, high);
            if(partition == len-k){
                kth = arr[partition];
                break;
            }
            if(partition < len -k){
                low = partition+1;
            } else {
                high = partition-1;
            }
        }
        return kth;
    }

    public static int getPartition(int[] arr, int l, int h){
        int pivot = arr[h];
        int i=l-1;

        for(int j=l; j<h; j++){
            if(arr[j]<pivot){
                i++;
                swap(arr, j, i);
            }
        }
        i++;
        swap(arr, i,h);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static  void printInput(int[] input){
        for(int i : input){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
