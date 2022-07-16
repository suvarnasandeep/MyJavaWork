package Sorting;

public class SortMain {
    public static void main(String[] args) {
        //insertionSort();
        //bubbleSort();
        //selectionSort();

        //mergeSort();
        quickSort();
    }

    private static void quickSort() {
        int[] input = new int[]{25, 2, 9, 50, 8, 1};
        printInput(input);
        QuickSort.doQuickSort(input);
        printInput(input);
    }

    private static void mergeSort() {
        int[] input = new int[]{25, 2, 9, 50, 8, 1};
        printInput(input);
        MergeSort.doMergeSort(input);
        printInput(input);
    }

    public static void selectionSort(){
        int[] input = new int[]{25, 2, 9, 50, 8, 1};
        printInput(input);
        SelectionSort.doSelectionSort(input);
        printInput(input);
    }

    private static void bubbleSort() {
        int[] input = {15,3,10,52,8,36};
        BubbleSort.doBubbleSort(input);
    }

    private static void insertionSort() {
        int[] input = {15,3,10,52,8,36};
        printInput(input);
        InsertionSort.doInsertionSort(input);
        printInput(input);
    }

    public static  void printInput(int[] input){
        for(int i : input){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
