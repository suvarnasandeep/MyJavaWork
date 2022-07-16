package Searching;

public class BinarySearch {

    public void binarySearch(int[] arr, int toSearch){

        int start = 0;
        int end = arr.length-1;

        doBinarySearch(arr,start,end,toSearch);

    }

    private void doBinarySearch(int[] arr, int start, int end, int toSearch) {
        if(start > end){
            System.out.println("Number " + toSearch +" not found");
        } else{
            int mid = start + (end-start)/2;
            if(arr[mid] == toSearch){
                System.out.println("Number " + +toSearch + " found at " + mid);
                return;
            }else if(arr[mid] > toSearch){
                doBinarySearch(arr, start, mid-1,toSearch );
            } else {
                doBinarySearch(arr,mid+1,end,toSearch);
            }
        }
    }
}
