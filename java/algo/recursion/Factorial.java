package algo.recursion;

public class Factorial {

    public static void main(String[] args)
    {
        System.out.println("Factorial of  " + 4 + " natural numbers : " + recursiveFactorial(4));
        System.out.println("Factorial of  " + 5 + " natural numbers : " + recursiveFactorial(5));
        System.out.println("Factorial of  " + 6 + " natural numbers : " + recursiveFactorial(6));
        System.out.println("Factorial of  " + 7 + " natural numbers : " + recursiveFactorial(7));
    }

    private static int recursiveFactorial(int n)
    {
        if (n == 0 || n == 1){
            return 1;
        }
        else {
            return recursiveFactorial(n-1) * n;
        }
    }


}
