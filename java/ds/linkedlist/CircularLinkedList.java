package ds.linkedlist;

public class CircularLinkedList
{
    private static CNode head;
    private static boolean  flag = false;
    public static class CNode
    {
        int data;
        CNode next;
    }

    public static void createCircularLinkedList(int[] arr, int n)
    {
        CNode t; // this is to create the new temp node
        CNode last; // this is to keep moving the list forward and linking

        // the first step is to create the head node and
        // assign the value to its data
        // finally we need to make head point to itself - this will be a circular linked list with one element that points back to itself.
        head = new CNode();
        head.data = arr[0];
        head.next = head;

        last = head; // this means that head and last are pointing to the same node currently

        for (int i = 1 ; i < n ; i++)
        {
            t = new CNode();
            t.data = arr[i];
            t.next = last.next; // make t point to the previous node's next

            last.next = t; // now, make the previous node's next point to t
            last = t; // now, move the last node to t
        }
    }

    public static void display(CNode node)
    {
        do
        {
            System.out.println(node.data);
            node = node.next;
        }
        while ( node != head);
        System.out.println("\n");
    }
    
    public static boolean isLoop()
    {
        CNode p = head;
        CNode q = head;

        do
        {
            p = p.next;
            q = q.next;
            q = q != null ? q.next : q; // don't blindly move q to next ; q could be null at this point, so check for this condition
        }
        while (p != null && q != null && p != q);

        if (p == q)
        {
            System.out.println("\n The given linked list is a LOOP");
        }
        else
        {
            System.out.println("\n The given linked list is LINEAR");
        }

        return p == q ? true : false;
    }

    public static void recursiveDisplay(CNode node)
    {
        if (node != head || !flag)
        {
            flag = true;
            System.out.println(node.data);
            recursiveDisplay(node.next);
        }

        flag = false;
    }

    public static void insert(int val , int position)
    {
        CNode p = head;
        CNode temp;

        if (position == 0)
        {
            temp = new CNode();
            temp.data = val;

            if (head == null)
            {
                head = temp;
                head.next = head;
            }
            else
            {
                while (p.next != head)
                {
                    p = p.next;
                }

                p.next = temp;
                temp.next = head;
                head = temp;
            }
        }


        for (int i=0 ; i < position-1; i++)
        {
            p = p.next;
        }

        temp = new CNode();
        temp.data = val;
        temp.next = p.next;
        p.next = temp;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};
        createCircularLinkedList(arr, 5);
        recursiveDisplay(head);
        System.out.println("Is loop ? " + isLoop());
    }
}
