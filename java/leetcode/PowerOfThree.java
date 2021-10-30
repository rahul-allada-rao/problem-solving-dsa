package leetcode;

public class PowerOfThree
{
    public static boolean isPowerOfThree(int n) {

        if (n == 3)
        {
            return true;
        }

        int result = 1;
        for (int i =1 ; i < n/2 ; i++)
        {
            result = result * i * 3;
            if (n == result)
            {
                return true;
            }
            else continue;
        }
        return false;
    }

    public static void main(String[] args)
    {
        boolean isPowerOfThree = isPowerOfThree(27);
        System.out.println(isPowerOfThree);
    }


}
