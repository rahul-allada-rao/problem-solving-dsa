package leetcode;

/**
 * Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class FindIndexOfElementsMatchingTarget {

//    public static void main(String[] args)
//    {
//        int[] num = {2,7,11,15};
//        int target = 9;
//        int[] result = new int[2];
//        int[] result2 = {0,1};
//
//        for (int i=0 ; i < num.length ; i++)
//        {
//            for (int j = i+1 ; j< num.length ; j++)
//            {
//                if (num[i] + num[j] == target)
//                {
//                    result[0] = i;
//                    result[1] = j;
//                    break;
//                }
//            }
//        }
//        assert result == result2;
//    }

    // using recursion - not working
    public static void main(String[] args)
    {
        int[] num = {2,7,11,15};
        int target = 9;

        int[] result = new int[2];
        int[] result2 = {0,1};

        int sum = 0;
        int i=0,j=0;

        while (sum != target && i< num.length && j+1 < num.length)
        {
            sum = num[i] + num[j];
            i++; j++;
        }
        result[0] = i;
        result[1] = j;

        assert result == result2;
    }
}
