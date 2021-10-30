package leetcode;

public class SmallerNumbersThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i=0; i<nums.length; i++){
            int currentNum = nums[i];
            int count=0;

            for (int j=0; j<nums.length; j++){
                if (nums[j] < currentNum){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void display(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print("\t" + arr[i]);
        }
    }

    /*
        Input: nums = [8,1,2,2,3]
        Output: [4,0,1,1,3]
        Given the array nums, for each nums[i]
        find out how many numbers in the array are smaller than it.
        That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
     */
    public static void main(String[] args)
    {
        int[] nums = {8,1,2,2,3};
        display(smallerNumbersThanCurrent(nums));
    }
}
