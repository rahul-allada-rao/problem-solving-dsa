package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RunningSum {

    public static int[] runningSum(int[] nums) {
        int runningSum=nums[0];
        int[] finalArray = new int[nums.length];
        finalArray[0] = runningSum;

        for (int i=1; i< nums.length; i++){
            runningSum = runningSum + nums[i];
            finalArray[i] = runningSum;
        }
        return  finalArray;
    }

    public static void display(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print("\t" + arr[i]);
        }
    }

    /*
    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     */
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4};
        int[] finalArray = runningSum(arr);

        display(finalArray);
    }
}
