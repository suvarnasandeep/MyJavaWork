package DataStructureAlgorithm.Arrays;

public class RotatedArraySearch {
    /*
     *Search an element in a sorted and rotated array
     *O(log n)
     *Input arr[] = {3, 4, 5, 1, 2}
     *Element to Search = 1
     *1) Find out pivot point and divide the array in two
     *    sub-arrays. (pivot = 2) //Index of 5
     *2) Now call binary search for one of the two sub-arrays.
     *    (a) If element is greater than 0th element then
     *           search in left array
     *    (b) Else Search in right array
     *        (1 will go in else as 1 < 0th element(3))
     *3) If element is found in selected sub-array then return index
     *   Else return -1.
     */
    public void pivotedBinarySearch(int arr[], int n, int key) {
        printArray(arr);
        int pivot = findPivot1(arr, 0, n-1);

        int[]arr1 = {6,7,1,2,3,4,5};
        int pivot1 = findPivot1(arr1, 0, n-1);

        System.out.println("pivot : " + pivot);

        if(pivot == -1)
            System.out.println(key + " found at index : " + binarySearch(arr, 0, n-1, key));

        if(arr[0] <= key) {
            System.out.println(key + " found at index : " + binarySearch(arr, 0, pivot, key));
        } else {
            System.out.println(key + " found at index : " + binarySearch(arr, pivot+1, n-1, key));
        }
    }


    public int modifiedBinarySearch(int[]arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + ((end-start) / 2);

        if(arr[mid] == target)
            return mid;

        // find left half sorted
        if(arr[mid] > arr[start]){
            //if key in left half
            if(arr[start] >= target && arr[mid] <= target){
                return modifiedBinarySearch(arr, target, start, mid-1);
            } else {
                return  modifiedBinarySearch(arr,target,mid+1, end);
            }
        } else {
            //if key is right half
            if(arr[mid] >= target && arr[end] <= target){
                return modifiedBinarySearch(arr, target, mid+1, end);
            } else {
                return modifiedBinarySearch(arr,target,start, mid-1);
            }
        }
    }

    //O(n)
    public int findPivot(int arr[], int l, int h) {

        if(h < l)
            return -1;
        if(h == l)
            return l;

        int mid = (l + h)/2;
        if(mid < h && arr[mid] > arr[mid+1])
            return mid;
        if(mid > l && arr[mid] < arr[mid-1])
            return mid-1;
        if(arr[l] >= arr[mid]) {
            return findPivot(arr, 0, mid-1);
        } else {
            return findPivot(arr, mid+1, h);
        }
    }

    //O(lon n)
    public int findPivot1(int arr[], int low, int high) {
        while(low < high)
        {
            int mid = (low + high) / 2;
//            int mid = low + (high - low) / 2;
//            if (arr[mid] == arr[high])
//                high--;
//            else
                if(arr[mid] > arr[high])
                 low = mid + 1;
                else
                 high = mid;
        }
        return high;
    }

    public int binarySearch(int arr[], int l, int h, int key) {
        if(h < l)
            return -1;

        int mid = (l+h)/2;
        if(key == arr[mid])
            return mid;

        if(key > arr[mid])
            return binarySearch(arr, mid+1, h, key);
        return binarySearch(arr, l, mid-1, key);
    }

    public void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Utils.setSeparator("Search an element in a sorted and rotated array");
        RotatedArraySearch rArr = new RotatedArraySearch();
        int[]arr = {3,4,5,6,7,1,2};
        int length = arr.length;
        rArr.pivotedBinarySearch(arr, length, 5);
        System.out.println("Modified Binary serach : " + rArr.modifiedBinarySearch(arr,5,0, arr.length-1));

    }
}
