package DataStructureAlgorithm.Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if(n<0)
            return -1;
        if(n==0 || n==1)
            return n ;


        return fibonacci(n-1) + fibonacci(n-2);

    }
}
