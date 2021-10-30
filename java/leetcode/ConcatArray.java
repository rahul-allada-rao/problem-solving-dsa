package leetcode;

public class ConcatArray {

    public static int[] getConcatenation(int[] nums) {

        int[] ans = new int[nums.length*2];

        for (int i=0; i<ans.length; i++){

            if (i < nums.length){
                ans[i] = nums[i];
            }
            else {
                ans[i] = nums[i-nums.length];
            }
        }

        return ans;
    }

    public static void display(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print("\t" + arr[i]);
        }
    }

    /*
        Input: nums = [1,2,1]
        Output: [1,2,1,1,2,1]
        Explanation: The array ans is formed as follows:
        - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
        - ans = [1,2,1,1,2,1]
     */
    public static void main(String[] args)
    {
        int[] nums = {1,2,1};
        display(nums);
        System.out.println();

        display(getConcatenation(nums));
    }
}
