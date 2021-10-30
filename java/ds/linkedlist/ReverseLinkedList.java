package ds.linkedlist;

public class ReverseLinkedList {

    
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     

        public static ListNode reverseList(ListNode head) {

            ListNode previousNode = null;
            ListNode nextNode = null;
            ListNode currentNode = head;

            while(currentNode != null)
            {
                nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }

            head = previousNode;

            return head;
        }


    /**
     * Input: head = [1,2,3,4,5]
     Output: [5,4,3,2,1]
     * @param args
     */
    public static void main(String[] args)
    {
        ListNode seven = new ListNode(7, null);
        ListNode six = new ListNode(6, seven);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);


        ListNode newHead = reverseList(head);

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
