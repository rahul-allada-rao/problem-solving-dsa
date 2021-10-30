package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1
 *  Input: s = "leetcode"
    Output: 0

 Input: s = "loveleetcode"
 Output: 2

 Input: s = "aabb"
 Output: -1
 */
public class NonRepeatingCharacter {

    public static int firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        Map<String, Integer> charCountMap = new HashMap<>();

        int nonRepeatingCharIndex = -1;

        for (int i = 0 ; i < chars.length ; i++)
        {
            if (!charCountMap.containsKey(String.valueOf(chars[i])))
            {
                charCountMap.put(String.valueOf(chars[i]), 1);
            }
            else
            {
                int currentCount = charCountMap.get(String.valueOf(chars[i]));
                charCountMap.put(String.valueOf(chars[i]), ++currentCount);
            }
        }

        for (int i = 0 ; i < chars.length ; i++)
        {
            if (charCountMap.get(String.valueOf(chars[i])) == 1)
            {
                nonRepeatingCharIndex = i;
                break;
            }
        }

        return  nonRepeatingCharIndex;
    }

    public static void main(String[] args)
    {
        String s1 = "leetcode";
        System.out.println("leetcode expected = 0, actual = " + firstUniqChar(s1));

        String s2 = "loveleetcode";
        System.out.println("loveleetcode expected = 2, actual = " + firstUniqChar(s2));

        String s3 = "aabb";
        System.out.println("aabb expected = -1, actual = " + firstUniqChar(s3));

        String s4 = "dddccdbba";
        System.out.println("dddccdbba expected = 8, actual = " + firstUniqChar(s4));
    }
}
