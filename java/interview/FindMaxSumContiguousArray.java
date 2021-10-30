package interview;

import java.util.Map;

//https://leetcode.com/problems/maximum-subarray/submissions/

public class FindMaxSumContiguousArray
{

    public static void main(String[] args)
    {
        int[] arr1 = {-2,-1,0,2,3} ; // 5
        int[] arr2 = {1,0,0,-1,4} ; // 3
        int[] arr3 = {0,4} ; // 4

        int sum1 = maxSubArray(arr1);
        System.out.println("Expected 5, actual " + sum1);

        int sum2 = maxSubArray(arr2);
        System.out.println("Expected 4, actual " + sum2);

        int sum3 = maxSubArray(arr3);
        System.out.println("Expected 4, actual " + sum3);


        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArray(a));
    }

    // {1}
    public static int maxSubArray(int[] nums)
    {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i=1; i<nums.length; i++)
        {
            int sum = currentSum + nums[i];

            if (sum <= nums[i]){
                currentSum = nums[i];
            }
            else{
                currentSum = sum;
            }

            if (maxSum <= currentSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }


}
