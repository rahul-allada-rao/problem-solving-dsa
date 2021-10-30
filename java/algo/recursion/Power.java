package algo.recursion;

public class Power {

    public static void main(String[] args)
    {
        int m = 5;
        int n = 2;
        System.out.println(m + " to the power of " + n + " : " + pow(m,n));
        System.out.println(m + " to the power of " + n + " by halving method : " + powByHalving(m,n));

    }

    public static int pow(int m, int n){

        if (n == 0){
            return 1;
        }

        return pow(m, n-1) * m;
    }

    public static int powByHalving(int m, int n){

        if (n == 0){
            return 1;
        }

        if ( n %2 == 0){
            return pow(m*m, n/2);
        }
        else {
            return pow(m*m, (n-1)/2 ) * m;
        }
    }
}
