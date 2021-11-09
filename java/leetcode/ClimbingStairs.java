package leetcode;

import java.io.IOException;
import java.util.Scanner;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

  public static int m[] = new int[1000];

  public static void main(String[] args) {
    System.out.println(climbStairs(6));
  }

  public static int climbStairs(int n) {
    if (n <= 3) {
      m[n] = n;
      return n;
    }

    if (m[n - 2] == 0) {
      m[n - 2] = climbStairs(n - 2);
    }
    if (m[n - 1] == 0) {
      m[n - 1] = climbStairs(n - 1);
    }
    return m[n - 1] + m[n - 2];
  }
}
