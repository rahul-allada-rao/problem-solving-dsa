package leetcode;

public class ShuffleArray {

    /**
     * Input: nums = [2,5,1,3,4,7], n = 3
     Output: [2,3,5,4,1,7]
     Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
     * @param args
     */
    public static void main(String[] args)
    {
        int[] nums = {2,5,1,3,4,7};
        display(shuffle(nums, 3));
    }

    public static void display(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print("\t" + arr[i]);
        }
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n*2];

        for (int i=0; i< nums.length; i+=2){
            ans[i] = nums[i/2];
            ans[i+1] = nums[i/2 + n];
        }
        return ans;

    }
}
