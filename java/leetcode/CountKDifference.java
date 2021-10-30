package leetcode;

public class CountKDifference {

    /*
    Input: nums = [1,2,2,1], k = 1
    Output: 4
    Explanation: The pairs with an absolute difference of 1 are:
    - [1,2,2,1]
    - [1,2,2,1]
    - [1,2,2,1]
    - [1,2,2,1]
     */
    public static void main(String[] args)
    {
        int[] nums = {1,2,2,1};
        int k=1;
        System.out.println(countKDifference(nums,k));


        int[] nums2 = {1,3};
        int k2=3;
        System.out.println(countKDifference(nums2,k2));

        int[] nums3 = {3,2,1,5,4};
        int k3=2;
        System.out.println(countKDifference(nums3,k3));
    }

    public static int countKDifference(int[] nums, int k) {

        int count=0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (Math.abs(nums[i] - nums[j]) == k){
                    count++;
                }
            }
        }

        return count;
    }
}
