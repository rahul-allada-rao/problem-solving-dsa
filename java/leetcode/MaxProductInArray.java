package leetcode;

public class MaxProductInArray {

    //not working
    public static int maxProduct(int[] nums) {
        int maxProduct = 1;
        int currentMaxProduct = 1;

        for(int i=0, j=i+1; i<nums.length && j< nums.length; i++,j++ ){
            int tempProduct = currentMaxProduct * (nums[i]-1) * (nums[j]-1);
            if (currentMaxProduct < tempProduct){
                currentMaxProduct = tempProduct;
            }

            if (maxProduct < currentMaxProduct){
                maxProduct = currentMaxProduct;
            }
        }

        return maxProduct;
    }

    /*
        Input: nums = [3,4,5,2]
        Output: 12
        Explanation: If you choose the indices i=1 and j=2 (indexed from 0),
        you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
     */
    public static void main(String[] args)
    {
        int[] nums = {3,4,5,2};
        System.out.println(maxProduct(nums));
    }
}
