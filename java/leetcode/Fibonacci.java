package leetcode;

import java.util.Arrays;

public class Fibonacci {

    public static int m[];

    public static int fib(int n) {

        if (n <=1)
            return n;

        return fib(n-2) + fib(n-1);
    }

    public static int fibUsingMemoization(int n)
    {

        if (n <=1)
        {
            m[n] = n;
            return n;
        }
        else
        {
            if (m[n-2] == -1)
            {
                m[n-2] = fibUsingMemoization(n-2);
            }

            if (m[n-1] == -1)
            {
                m[n-1] = fibUsingMemoization(n-1);
            }
        }


        return m[n-2] + m[n-1];
    }

    public static void main(String[] args)
    {
        int n=7;
        m = new int[n+1];
        Arrays.fill(m, -1);
        System.out.println(fibUsingMemoization(7));
    }
}
