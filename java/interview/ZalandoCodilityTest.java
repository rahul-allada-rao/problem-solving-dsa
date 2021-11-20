package interview;

import java.util.Arrays;

public class ZalandoCodilityTest {

  public static void main(String[] args) {
//    int[] A = {1, 3, 6, 4, 1, 2};
//    System.out.println(solution(A));
//
//    int[] B = {1, 2, 3};
//    System.out.println(solution(B));
//
//    int[] C = {-1, -3};
//    System.out.println(solution(C));

//    String s = "50552";
//    System.out.println(maxTwoDigit(s));
//
//    String s1 = "10101";
//    System.out.println(maxTwoDigit(s1));
//
//    String s2 = "88";
//    System.out.println(maxTwoDigit(s2));

//    String charStr = "aabbcc";
//    int[] C = {1, 2, 1, 2, 1, 2};
//    System.out.println(minCost(charStr, C));
//
//    String charStr2 = "abccbd";
//    int[] C2 = {0, 1, 2, 3, 4, 5};
//    System.out.println(minCost(charStr2, C2));
//
//    String charStr3 = "aaaa";
//    int[] C3 = {3, 4, 5, 6};
//    System.out.println(minCost(charStr3, C3));
//
//    String charStr4 = "ababa";
//    int[] C4 = {10, 5, 10, 5, 10};
//    System.out.println(minCost(charStr4, C4));

    int[] A = {5, 2, 4, 6, 3, 7};
    System.out.println(minCostOfBreakingChain(A));
  }

  public static int minCostOfBreakingChain(int[] A) {

    // initialize the minCost to be integer max
    int minCostOfBreaking = Integer.MAX_VALUE;

    // we need to honor the below conditions to arrive at the min cost of breaking the chain
    // 0 < P < Q < N-1
    // Q-P > 1
    // So, here  i and j will represent P and Q respectively and the min cost will be calculated
    for (int i = 1; i < A.length - 1; i++) {
      for (int j = i + 2; j < A.length - 1; j++) {
        int currentCost = A[i] + A[j];
        if (currentCost < minCostOfBreaking) {
          minCostOfBreaking = currentCost;
        }
      }
    }
    return minCostOfBreaking;
  }

  public static int minCost(String S, int[] C) {

    int minCostOfDeletion = 0;

    // compare each adjacent characters during each iteration to see if they are same
    // if adjacent characters are same, then calculate the cost of the first occurence from array C
    // at the same index as the iteration index
    for (int i = 0; i < S.length() - 1; i++) {
      if (S.charAt(i) == S.charAt(i + 1)) {
        minCostOfDeletion = minCostOfDeletion + C[i];
      }
    }
    return minCostOfDeletion;
  }

  public static int maxTwoDigit(String s) {

    // if length is 2, then this itself would be the largest 2 digit number
    if (s.length() == 2) {
      return Integer.parseInt(s);
    }

    int maxTwoDigitNumber = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      String currentTwoDigitNumber = s.substring(i, i + 2);

      if (maxTwoDigitNumber < Integer.parseInt(currentTwoDigitNumber)) {
        maxTwoDigitNumber = Integer.parseInt(currentTwoDigitNumber);
      }
    }
    return maxTwoDigitNumber;
  }

//  public static int solution(int[] A) {
//    Set<Integer> set = new HashSet<>();
//
//    for (int value : A) {
//      if (value > 0) set.add(value);
//    }
//
//    int missingInteger = 1;
//    while (true) {
//      if (!set.contains(missingInteger)) return missingInteger;
//      else missingInteger++;
//    }
//  }

  public static int solution(int[] A) {
    int[] sorted = Arrays.stream(A).distinct().sorted().toArray();

    int missingInteger = 1;
    for (int value : sorted) {
      if (value > 0) {
        if (value == missingInteger) missingInteger++;
        else break;
      }
    }
    return missingInteger;
  }

//  public static int solution(int[] A) {
//    // write your code in Java SE 8
//    int[] sortedList = Arrays.stream(A).sorted().toArray();
//    int missingInteger = 0;
//    for (int i = 0; i < sortedList.length - 1; i++) {
//      if ((sortedList[i] == sortedList[i + 1] - 1)
//              || sortedList[i] == sortedList[i + 1]) {
//        missingInteger = sortedList[i + 1] + 1;
//        continue;
//      } else {
//        missingInteger = sortedList[i] + 1;
//        if (missingInteger > 0) {
//          break;
//        } else {
//          continue;
//        }
//      }
//    }
//    if (missingInteger < 0) {
//      missingInteger = 1;
//    }
//    return missingInteger;
//  }
}
