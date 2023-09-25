package DataStructureAlgorithm.Recursion;

public class ReverseArrayRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5, 6};
        for(int i : arr)
            System.out.print(i + " ");
        reverse(arr, 0, arr.length-1);
        System.out.println();
        for(int i : arr)
            System.out.print(i + " ");

    }

    public static void reverse(int[] arr, int i, int n){
        if(i >= n )
            return;

        int tmp = arr[i];
        arr[i] = arr[n];
        arr[n] = tmp;
        reverse(arr, i+1, n-1);
    }
}
