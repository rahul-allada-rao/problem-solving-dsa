package leetcode;

public class FindGCD {

    /*
        Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

        The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

        Input: nums = [2,5,6,9,10]
        Output: 2
        Explanation:
        The smallest number in nums is 2.
        The largest number in nums is 10.
        The greatest common divisor of 2 and 10 is 2.
     */
    public static void main(String[] args)
    {
//        int[] nums = {2,5,6,9,10};
//        System.out.println(findGCD(nums));

        int[] nums2 = {7,5,6,8,3};
        System.out.println(findGCD(nums2));

//        int[] nums3 = {3,3};
//        System.out.println(findGCD(nums3));
    }

    public static int findGCD(int[] nums) {

        int smallestNumber = nums[0];
        int largestNumber = nums[0];

        for (int i=0; i<nums.length; i++){

            if (nums[i] < smallestNumber){
                smallestNumber = nums[i];
            }

            if (nums[i] > largestNumber){
                largestNumber = nums[i];
            }
        }

        System.out.println("smallestNumber " + smallestNumber);
        System.out.println("largestNumber " + largestNumber);

        // find gcd of smallestNumber and largestNumber
        return getGCD(largestNumber, smallestNumber);
    }

    private static int getGCD(int n1, int n2){
        if (n1 == 0){
            return n2;
        }

        if (n2 == 0){
            return n1;
        }

        return getGCD(n2, n1%n2);
    }
}
