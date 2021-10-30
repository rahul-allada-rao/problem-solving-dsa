package leetcode;

import com.sun.org.apache.regexp.internal.RE;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it in the maximum amount of balanced strings.

Return the maximum amount of split balanced strings.

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'


Constraints:

1 <= s.length <= 1000
s[i] is either 'L' or 'R'.
s is a balanced string.
 */
public class BalancedStringSplit
{

    public static int balancedStringSplit(String s)
    {
        int maxAmtOfSplitBalancedStrings = 0;
        int countOfL = 0;
        int countOfR = 0;

        char[] charArray = s.toCharArray();

        for (int i=0 ; i< charArray.length; i++)
        {
            if (charArray[i] == 'L')
            {
                countOfL++;
            }
            else if (charArray[i] == 'R')
            {
                countOfR++;
            }

            if (countOfL == countOfR)
            {
                maxAmtOfSplitBalancedStrings++;
                countOfL = 0;
                countOfR = 0;
            }
        }
        System.out.println(maxAmtOfSplitBalancedStrings);
        return maxAmtOfSplitBalancedStrings;
    }

    public static void main(String[] args)
    {
        String s = "RLLLLRRRLR";
        System.out.println("maxAmtOfSplitBalancedStrings for string " + s +  " are : " + balancedStringSplit(s));
    }
}
