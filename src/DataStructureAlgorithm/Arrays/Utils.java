package DataStructureAlgorithm.Arrays;

public class Utils {
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for(int i : arr)
            System.out.print(i + " ");

        System.out.println("]");
        //System.out.println("------------------------");
    }

    public static void printArray(int[] arr1, int[] arr2) {
        System.out.println("------------------------");
        System.out.print("[ ");
        for(int i : arr1)
            System.out.print(i + " ");

        System.out.println("]");
        System.out.print("[ ");
        for(int i : arr2)
            System.out.print(i + " ");

        System.out.println("]");


    }

    public static void setSeparator(String msg) {
        System.out.println("************" + msg +"*****************");
    }
}
