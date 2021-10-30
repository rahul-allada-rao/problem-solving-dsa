package leetcode;

public class IntersectingPointOfLinkedList {

    public static class ListNode {
      int val;
      ListNode next;

        public ListNode()
        {
        }

        ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return new ListNode(0);
        }

        ListNode a = headA;
        ListNode b = headB;
        ListNode intersectingNode;

        while (a.next != null & b.next !=null){

            int[] arr = {1, 2, 3, 4};
            int[] arr1 = new int[5];

            if (a.next.next == b.next.next){
                intersectingNode = a.next;
                return intersectingNode;
            }

            a = a.next;
            b = b.next;
        }
        return new ListNode(0);
    }

    public static void createLinkedList(int[] array, ListNode head)
    {
        ListNode temp;
        ListNode tail;
        head.val = array[0];
        head.next = null;
        tail = head;

        for (int i = 1 ; i < array.length; i++)
        {
            temp = new ListNode(array[i]);
            temp.next = null;

            tail.next = temp;
            tail = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] arr1 = {4,1,8,4,5};
        ListNode headA = new ListNode();
        createLinkedList(arr1, headA);


        int[] arr2 = {5,6,1,8,4,5};
        ListNode headB = new ListNode();
        createLinkedList(arr1, headB);

        ListNode intersection = getIntersectionNode(headA, headB);
        System.out.println(intersection.val);
    }

    /*
    8
[4,1,8,4,5]
[5,6,1,8,4,5]
2
3
2
[1,9,1,2,4]
[3,2,4]
3
1
0
[2,6,4]
[1,5]
3
2
     */
}
