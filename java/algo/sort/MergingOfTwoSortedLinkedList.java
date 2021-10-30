package algo.sort;

import ds.linkedlist.MyLinkedList;

public class MergingOfTwoSortedLinkedList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
            temp = new ListNode();
            temp.val = array[i];
            temp.next = null;

            tail.next = temp;
            tail = temp;
        }
    }

    /**
     * Time complexity = O(n) --> because printing is done for n number of nodes
     * Space complexity = 0 ?? --> todo: need to confirm on this.
     * @param rootNode
     */
    public static void printNodes(ListNode rootNode)
    {
        while (rootNode != null)
        {
            System.out.print(rootNode.val + "\t");
            rootNode = rootNode.next;
        }
    }


    public static void main(String[] args)
    {
        int[] array1 = {1,2,4};
        ListNode l1 = new ListNode();
        createLinkedList(array1, l1);
        System.out.println("First list : ");
        printNodes(l1);

        System.out.println("\n");
        int[] array2 = {1,3,4};
        ListNode l2 = new ListNode();
        createLinkedList(array2, l2);
        System.out.println("Second list : ");
        printNodes(l2);

        System.out.println("\n");
        ListNode finalList = mergeTwoLists(l1, l2);
        System.out.println("Expected ListNode [1,1,2,3,4,4]");
        printNodes(finalList);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode();
        ListNode temp = head;

        if(l1 == null && l2==null)
        {
            return l1;
        }

        if(l1 == null)
        {
            return l2;
        }

        if(l2==null)
        {
            return l1;
        }

        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }
            else
            {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }

        // below code populates the final sorted list with any leftover elements from first/second list
        if (l1 != null)
        {
            head.next = l1;
        }
        else
        {
            head.next = l2;
        }

        return temp.next;

    }

    public static ListNode mergeTwoListsNew(ListNode l1, ListNode l2)
    {
        ListNode list = new ListNode();
        ListNode temp = list;

        if(l1 == null && l2==null){ return l1;}
        if(l1 == null){ return l2;}
        if(l2==null){ return l1;}

        while(l1 != null && l2 != null)
        {
            if(l1.val<l2.val)
            {
                list.next = l1;
                l1 = l1.next;
                list = list.next;
            }
            else
            {
                list.next = l2;
                l2 = l2.next;
                list = list.next;
            }
        }

        if(l1 != null)
        {
            list.next = l1;
        }
        else
        {
            list.next = l2;
        }
        return temp.next;
    }
}



