package DataStructureAlgorithm.Recursion;

public class Factorial {
    public static void main(String[] args) {

        int n = 10;
        System.out.println(n + " != " + factorial(n));
    }

    private static int factorial(int n) {
        int fact = 1;
        if(n<0)
            return -1;
        if(n == 0){
            return 1;
        } else {
            fact = n * factorial(n-1);
            return fact;
        }
    }
}
