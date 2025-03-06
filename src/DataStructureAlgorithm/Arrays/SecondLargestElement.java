package DataStructureAlgorithm.Arrays;

public class SecondLargestElement {

    public static int getSecondLargest(int[] arr){
        int largest = arr[0];
        int secondLarge = -1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > largest){
                secondLarge = largest;
                largest = arr[i];
            }
            if(arr[i] < largest && arr[i] > secondLarge){
                secondLarge = arr[i];
            }
        }
        return secondLarge;
    }
    public static int getSecondSmallest(int[] arr){
        int smallest = arr[0];
        int secondSmall = Integer.MAX_VALUE;
        for (int i= 1; i<arr.length; i++){
            if (arr[i] < smallest){
                secondSmall = smallest;
                smallest = arr[i];
            }
            if(arr[i] > smallest && arr[i] < secondSmall){
                secondSmall = arr[i];
            }
        }
        return secondSmall;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,5};
        Utils.printArray(arr);
        System.out.println("second largest : " + getSecondLargest(arr));
        System.out.println("second smallest : " + getSecondSmallest(arr));
    }
}
