package leetcode;

public class JewelsAndStones
{

    public static int numJewelsInStones(String jewels, String stones) {

        char[] jewelsArray = jewels.toCharArray();
        char[] stonesArray = stones.toCharArray();
        int numJewelsInStones = 0;

        for (int i=0; i< jewelsArray.length; i++)
        {
            for (int j=0; j < stonesArray.length; j++)
            {
                if (jewelsArray[i] == stonesArray[j])
                {
                    numJewelsInStones++;
                }
            }
        }

        return numJewelsInStones;

    }

    public static void main(String[] args)
    {
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));
    }
}

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".



Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0


Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
 */