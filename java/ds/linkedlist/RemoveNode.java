package ds.linkedlist;

public class RemoveNode {


        public static ListNode removeElements(ListNode head, int val) {

            if (head == null)
                return head;

            ListNode temp = head;

            while (temp.next != null)
            {
                if (temp.next.val == val)
                {
                    temp.next = temp.next.next;
                }
                else
                {
                    temp = temp.next;
                }
            }

            if (head.val == val)
                return head.next;

            return head;
        }


    /**
     * Input: head = [1,2,6,3,4,5,6], val = 6
     Output: [1,2,3,4,5]
     * @param args
     */
    public static void main(String[] args)
    {
        ListNode seven = new ListNode(6, null);
        ListNode six = new ListNode(5, seven);
        ListNode five = new ListNode(4, six);
        ListNode four = new ListNode(3, five);
        ListNode three = new ListNode(6, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);


        ListNode newHead = removeElements(head, 6);
        printLinkedList(newHead);

    }

    private static void printLinkedList(ListNode head)
    {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }
}
