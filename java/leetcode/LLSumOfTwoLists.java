package leetcode;

// https://leetcode.com/problems/add-two-numbers/

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Constraints:

 The number of nodes in each linked list is in the range [1, 100].
 0 <= Node.val <= 9
 It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class LLSumOfTwoLists {

    public static class ListNode {
      int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     *  Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
     * @param args
     */
    public static void main(String[] args)
    {
        ListNode root1 = new ListNode();
        ListNode root2 = new ListNode();
//        int[] array1 = {2,4,3};
//        int[] array2 = {5,6,4};

        int[] array1 = {9,9,9,9,9,9,9};
        int[] array2 = {9,9,9,9};

        ListNode l1 = createLinkedList(array1, root1);
        System.out.println("First list: ");
        printNodes(root1);

        ListNode l2 = createLinkedList(array2, root2);
        System.out.println("\nSecond list: ");
        printNodes(root2);

        System.out.println("\nThird list: ");
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int sum=0;
        ListNode newHead = new ListNode();

        ListNode temp, tail;
        tail = newHead;

        int quotient = 0;
        int remainder = 0;

        while (l1 != null && l2 != null)
        {
            sum = l1.val + l2.val + quotient;
            quotient = sum / 10;
            remainder = sum % 10;

            temp = new ListNode();
            temp.val = remainder;
            temp.next = null;

            tail.next = temp;
            tail = temp;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null)
        {
            sum = l1.val + quotient;
            quotient = sum / 10;
            remainder = sum % 10;

            temp = new ListNode();
            temp.val = remainder;
            temp.next = null;

            tail.next = temp;
            tail = temp;

            l1 = l1.next;
        }

        while (l2 != null)
        {
            sum = l2.val + quotient;
            quotient = sum / 10;
            remainder = sum % 10;

            temp = new ListNode();
            temp.val = remainder;
            temp.next = null;

            tail.next = temp;
            tail = temp;

            l2 = l2.next;
        }

        if (quotient > 0)
        {
            temp = new ListNode();
            temp.val = quotient;
            temp.next = null;
            tail.next = temp;
            tail = temp;
        }

        printNodes(newHead.next);
        return newHead.next;
    }

    public static ListNode createLinkedList(int[] array, ListNode head)
    {
        ListNode temp;
        ListNode tail;
        head.val = array[0];
        head.next = null;
        tail = head;

        for (int i = 1 ; i < array.length; i++)
        {
            temp = new ListNode();
            temp.val = array[i];
            temp.next = null;

            tail.next = temp;
            tail = temp;
        }

        return head;
    }

    public static void printNodes(ListNode rootNode)
    {
        while (rootNode != null)
        {
            System.out.print(rootNode.val + "\t");
            rootNode = rootNode.next;
        }
    }
}
