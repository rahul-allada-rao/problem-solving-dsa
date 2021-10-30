package algo.recursion;

import java.util.Arrays;

public class Fibonacci {

    public static int[] fib;


    public static void main(String[] args)
    {
        int n = 7;
        fib = new int[n+1];
        Arrays.fill(fib, -1);

        System.out.println("Regular fibonacci for " + n + " : " + fibWithRecursion(n));
        System.out.println("Memoization fibonacci for " + n + " : " + fibWithMemoization(n));
        System.out.println("Iterative fibonacci for " + n + " : " + fibWithIteration(n));
    }

    public static int fibWithRecursion(int n){

        if (n == 0 || n == 1) {
            return n;
        }

        return fibWithRecursion(n-2) + fibWithRecursion(n-1);
    }

    public static int fibWithMemoization(int n){

        if (n <= 1)
        {
            fib[n] = n;
            return n;
        }
        else
        {
            if (fib[n-2] == -1){
                fib[n-2] = fibWithMemoization(n-2);
            }

            if (fib[n-1] == -1){
                fib[n-1] = fibWithMemoization(n-1);
            }
        }

        return fib[n-2] + fib[n-1];
    }

    public static int fibWithIteration(int n){
        int sum =0;
        int term0 = 0;
        int term1 = 1;

        if (n <= 1){
            sum = n;
            return sum;
        }

        for (int i=1; i<n; i++){
            sum = term0 + term1;
            term0 = term1;
            term1 = sum;
        }
        return sum;
    }
}
