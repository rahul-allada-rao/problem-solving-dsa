package leetcode;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Tribonacci {
  public static int m[] = new int[1000];

  public static void main(String[] args) {
//    int n = 7;
//    m = new int[n + 1];
//    Arrays.fill(m, -1);
    System.out.println(tribonacci(4));
  }

  public static int tribonacci(int n) {

    if (n == 0) {
      m[n] = 0;
      return 0;
    } else if (n <= 2) {
      m[n] = 1;
      return 1;
    } else {
      if (m[n - 3] == 0) {
        m[n - 3] = tribonacci(n - 3);
      }

      if (m[n - 2] == 0) {
        m[n - 2] = tribonacci(n - 2);
      }

      if (m[n - 1] == 0) {
        m[n - 1] = tribonacci(n - 1);
      }

      return m[n - 3] + m[n - 2] + m[n - 1];
    }
  }
}
