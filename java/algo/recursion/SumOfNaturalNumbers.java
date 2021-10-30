package algo.recursion;

public class SumOfNaturalNumbers {

    public static void main(String[] args)
    {
//        System.out.println("Sum of first " + 5 + " natural numbers : " + recursiveNaturalSum(5));
//        System.out.println("Sum of first " + 6 + " natural numbers : " + recursiveNaturalSum(6));
//        System.out.println("Sum of first " + 7 + " natural numbers : " + recursiveNaturalSum(7));
//
//        System.out.println("Using AP formula");
//        System.out.println("Sum of first " + 5 + " natural numbers : " + factorialWithArithmeticProgressionFormula(5));
//        System.out.println("Sum of first " + 6 + " natural numbers : " + factorialWithArithmeticProgressionFormula(6));
//        System.out.println("Sum of first " + 7 + " natural numbers : " + factorialWithArithmeticProgressionFormula(7));
//
//        System.out.println("Using iteration");
//        System.out.println("Sum of first " + 5 + " natural numbers : " + iterative(5));
//        System.out.println("Sum of first " + 6 + " natural numbers : " + iterative(6));
//        System.out.println("Sum of first " + 7 + " natural numbers : " + iterative(7));

        int n=10;
        System.out.println("Sum of first " + n + " natural numbers : " + recursiveNaturalSum(n));
        System.out.println("Sum of first " + n + " natural numbers : " + factorialWithArithmeticProgressionFormula(n));
        System.out.println("Sum of first " + n + " natural numbers : " + iterative(n));
    }

    private static int recursiveNaturalSum(int n)
    {
        if (n == 0 || n == 1){
            return 1;
        }
        else {
            return recursiveNaturalSum(n-1) + n;
        }
    }

    private static int factorialWithArithmeticProgressionFormula(int n){
        return n * (n+1)/2;
    }

    private static int iterative(int n){
        int sum =0;

        for (int i=1; i<=n; i++){
            sum = sum + i;
        }
        return sum;
    }
}
