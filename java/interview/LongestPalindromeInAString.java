package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;

/**
 * Input:
 S = "aaaabbaa"
 Output: aabbaa
 Explanation: The longest Palindromic
 substring is "aabbaa".
 */
public class LongestPalindromeInAString {

    public static void main(String[] args)
    {
        String s1 = "aaaabbaa";
        System.out.println("Longest palindromic sub string in  " + s1 + " is ? " + newTest(s1) );

        String s3 = "madam";
        System.out.println("Longest palindromic sub string in  " + s3 + " is ? " + newTest(s3) );

        String s2 = "abc";
        System.out.println("Longest palindromic sub string in  " + s2 + " is ? " + newTest(s2) );

        String s4 = "babad";
        System.out.println("Longest palindromic sub string in  " + s4 + " is ? " + newTest(s4) );


        String s5 = "cbbd";
        System.out.println("Longest palindromic sub string in  " + s5 + " is ? " + newTest(s5) );

        String s6 = "ababad";
        System.out.println("Longest palindromic sub string in  " + s6 + " is ? " + newTest(s6) );
    }

//    //"babad"
//    public static String longestPalindrome1(String s)
//    {
//        int start = 0;
//        int end = s.length()-1;
//        for (int i=0; i<s.length(); i++)
//        {
//            start = i;
//            for (int j=end; j>=0; j--)
//            {
//                if (s.charAt(i) != s.charAt(j))
//                {
//                    end = j-1;
//                    continue;
//                }
//            }
//        }
//
//        String finalString = s.substring(start, end);
//        return finalString;
//    }


    //"babad"
    public static String newTest(String s)
    {
        int start=0;
        int end=0;
        String finalStr;

        for (int i=0; i< s.length(); i++)
        {
            for (int j=s.length()-1-i; j>1; j--)
            {
                if (s.charAt(i) != s.charAt(j))
                {
                    continue;
                }
                else
                {
                    end++;
                    break;
                }
            }
        }
        finalStr = s.substring(start, end);
        return finalStr;
    }

    public static String test(String s)
    {
        StringBuilder tempString = new StringBuilder();
        List<String> stringList = new ArrayList<>();

        for (int i=0; i<s.length(); i++)
        {
            for (int j=s.length()-1; j>=0 ; j--)
            {
                if (s.charAt(i) != s.charAt(j))
                {
                    continue;
                }
                else
                {
                    tempString.append(s.charAt(i));
                    i++;
                    continue;
                }
            }
            stringList.add(tempString.toString());
            tempString = new StringBuilder();
        }

        Optional<String> longestString = stringList.stream().max(Comparator.comparingInt(String::length));

        return longestString.get();
    }


    //String s1 = "aaaabbaa";
    public static String longestPalindrome(String str)
    {
        String originalString = str;
        StringBuilder longestPalindromeSubString = new StringBuilder();
        int length = str.length();
        for (int i=0; i< length-1; i++)
        {
            for (int j=length-1-i; j>=0; j--)
            {
                if (str.charAt(i) != str.charAt(j))
                {
                    str = str.substring(i);
                    length = str.length();
                    i=0;
                    j=length-1-i;
                }
                break;
            }
        }

        if (originalString.equals(str))
        {
            str = str.substring(0,1);
        }
        return str;
    }

//    public static boolean findLongestPalindrome(String s)
//    {
//        char[] arr = s.toCharArray();
//        boolean isPalindrome = true;
//        StringBuilder longestPalindromeSubString = new StringBuilder();
//
//        for (int i=0 ; i < arr.length ; i++)
//        {
//            for (int j=arr.length - 1 - i; j>=0; j--)
//            {
//                if (arr[i] != arr[j])
//                {
//                    j=arr.length - 1;
//                    i = i-1;
//                    longestPalindromeSubString = new StringBuilder();
//                    break;
//                }
//                else
//                {
//                    longestPalindromeSubString.append(arr[i]);
//                }
//                break;
//            }
//        }
//        System.out.println(longestPalindromeSubString);
//        return isPalindrome;
//    }

}
