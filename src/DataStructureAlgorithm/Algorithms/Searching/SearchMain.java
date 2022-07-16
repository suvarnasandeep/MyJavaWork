package Searching;

public class SearchMain {
    public static void main(String[] args) {

        //sortedLinearSearch();

        binarySearch();
    }

    private static void binarySearch() {
        int[] input = {1,3,5,9,10,15,90,99};
        printInputArray(input);
        int toSearch = 15;
        BinarySearch obj = new BinarySearch();
        obj.binarySearch(input, toSearch);
    }

    private static void sortedLinearSearch() {
        int[] input = {1,3,5,9,10,15,90,99};
        printInputArray(input);
        int toSearch = 6;
        LinearSearch obj = new LinearSearch();
        obj.linearSearch(input, toSearch);
    }

    private static void printInputArray(int[] arr) {
        System.out.print("[ ");
        for(int i : arr)
            System.out.print(i + " ");

        System.out.println("]");
        System.out.println("------------------------");
    }
}
