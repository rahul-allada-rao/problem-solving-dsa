package leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PangramChecker
{
    public static void main(String[] args)
    {
        String sentence1 = "leetcode";//"thequickbrownfoxjumpsoverthelazydog";
        String sentence2 = "thequickbrownfoxjumpsoverthelazydog";
        String sentence3 = "thequickbrownfoxjumpsoverthelazydogthequickbrownfoxjumpsoverthelazydog";
        System.out.println("Is Pangram? " + checkIfPangram(sentence1));
        System.out.println("Is Pangram? " + checkIfPangram(sentence2));
        System.out.println("Is Pangram? " + checkIfPangram(sentence3));
    }

    public static boolean checkIfPangram(String sentence)
    {
        Set<Character> charSet = new LinkedHashSet<>();
        char[] charArray = sentence.toCharArray();

        // add all characters into a set, no matter their occurence
        for (int i=0; i < charArray.length; i++)
        {
            charSet.add(charArray[i]);
        }

        boolean isPangram = true;

        // after adding to the set, if the size is less than 26 (count of all alphabets) then
        // it means that at least one alphabet is not present
        // in the original sentence and thus cannot be a pangram.
        if (charSet.size() < 26)
        {
            isPangram = false;
        }

        // below code to strictly compare lower case values for a-z
//        // loop through all ascii values for a-z i.e. 97-122, if any one is not present then its not a pangram
//        for (int i=97; i<=122; i++)
//        {
//            if (!charSet.contains(i))
//            {
//                isPangram = false;
//                break;
//            }
//        }
        return isPangram;
    }
}


/*
 A pangram is a sentence where every letter of the English alphabet appears at least once.

 Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



 Example 1:

 Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 Output: true
 Explanation: sentence contains at least one of every letter of the English alphabet.
 Example 2:

 Input: sentence = "leetcode"
 Output: false


 Constraints:

 1 <= sentence.length <= 1000
 sentence consists of lowercase English letters.
 */