package leetcode;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class IntersectionOfLinkedList {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }


  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode intersectionNode = null;

      Stack<ListNode> stackA = new Stack<>();
      while (headA != null){
        stackA.push(headA);
        headA = headA.next;
      }

    Stack<ListNode> stackB = new Stack<>();
      while (headB != null){
        stackB.push(headB);
        headB = headB.next;
      }

      while (!stackA.isEmpty() && !stackB.isEmpty())
      {
        ListNode node1 = stackA.pop();
        ListNode node2 = stackB.pop();

        if (node1 != node2)
          break;
        intersectionNode = node1;
      }
      return intersectionNode;
  }
}
