package DataStructureAlgorithm.Algorithms.Sorting;

public class BubbleSort {
    /**
    * Time Complexity :- O(n2)
    **/
    public static void doBubbleSort(int[] input){
        printInput(input);
        System.out.println("-------------------");
        for(int i=0; i<input.length; i++){
            for(int j=1; j<input.length-i; j++){
                if(input[j] <= input[j-1]){
                    int tmp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = tmp;
                }
            }
            printInput(input);
        }
    }

    public static  void printInput(int[] input){
        for(int i : input){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public  static void doBubbleSort1(int[] arr){
        printInput(arr);
        for(int i=0; i<arr.length;i++){
            for(int j =1; j<arr.length-i; j++){
                if(arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        printInput(arr);
    }
}
