package leetcode;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

//https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
public class ValidWordsInAPuzzle {

  public static void main(String[] args) {
    String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
    String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
    System.out.println("Expected: [1,1,3,2,4,0]   Actual: " + findNumOfValidWords(words, puzzles));
  }

  // Time limit exceeded for the below solution
  public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    List<Integer> result = new ArrayList<>();
    for (String puzzle : puzzles) {
      int count = 0;
      for (String word : words) {
        boolean validWord = true;
        for (int i = 0; i < word.length(); i++) {
          if (!word.contains(String.valueOf(puzzle.charAt(0)))
                  || !puzzle.contains(String.valueOf(word.charAt(i)))) {
            validWord = false;
            break;
          }
        }
        if (validWord) {
          count++;
        }
      }
      result.add(count);
    }

    return result;
  }
}
