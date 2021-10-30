package ds.linkedlist;

public class PalindromeTest {
    
    public static boolean isPalindrome(ListNode head) {


        return true;
    }


    /**
     * Input: head = [1,2,2,1], val = 6
     Output: true
     * @param args
     */
    public static void main(String[] args)
    {
        ListNode four = new ListNode(2, null);
        ListNode three = new ListNode(2, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);


        boolean isPalindrome = isPalindrome(head);
        System.out.println(isPalindrome);

    }
}
