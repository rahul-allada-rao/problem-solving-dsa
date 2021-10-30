package leetcode;

import java.util.Stack;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 *
 */
public class PalindromeTest {

    private static Stack<Integer> stack = new Stack<>();
      public static class ListNode
      {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public static boolean isPalindrome(ListNode head)
    {
        ListNode temp = head;

        // traverse the linked list from head to the last and keep pushing the values into a stack
        while (temp != null)
        {
            stack.push(temp.val);
            temp = temp.next;
        }

        boolean isPalindrome = false;
        temp = head; // reuse the temp variable and assign it again to head

        /* traverse through the linked list until list is not null and stack is not empty
         pop the value from stack and compare it with the head
         since stack works on a LIFO principle, if the node's value matches with the popped value then it will continue.
        if there is no mismatch, then it means that its a palindrome; else its not and we will break from the loop. **/
        while (!stack.empty() && temp != null)
        {
            if (stack.pop() == temp.val)
            {
                isPalindrome = true;
                temp = temp.next;
            }
            else
            {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    public static void main(String[] args)
    {
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(1);
        ListNode head = new ListNode(1);

        head.next = second;
        second.next = third;
        third.next = fourth;

        isPalindrome(head);

    }
}
