package ds.linkedlist;

public class DoublyLL
{
    public static DoubleNode first;

    public static class DoubleNode
    {
        int data;
        DoubleNode next;
        DoubleNode prev;
    }


    public static void create(int[] arr, int n)
    {
        first = new DoubleNode();
        first.data = arr[0];
        first.prev = null;
        first.next = null;

        DoubleNode temp, last;
        int i;

        last = first;

        for (i = 1; i < n; i++)
        {
            temp = new DoubleNode();
            temp.data = arr[i]; // create new node and assign data

            temp.next = last.next; // temp->next should point to last->next
            temp.prev = last; // temp->prev should point to last
            last.next = temp; // last->next should point to temp
            last = temp; // finally move the last to the newly create node
        }
    }

    public static void display(DoubleNode first)
    {
        DoubleNode temp = first;

        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public static void reverseDoublyLinkedList()
    {
        DoubleNode p = first;
        DoubleNode temp;
        while (p != null)
        {
            temp = p.next;
            p.next = p.prev;
            p.prev = temp;
            p = p.prev;

            if (p != null && p.next == null)
            {
                first = p;
            }
        }
    }

    public static int countNumberOfNodes(DoubleNode first)
    {
        DoubleNode temp = first;
        int counter = 0;
        while(temp != null)
        {
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    public static void insert(int data, int position)
    {
        DoubleNode newNode = new DoubleNode();
        newNode.data = data;

        // check for scenario where position is < 0 and position > length of linked list

        // insert the new node before the current first
        if (position == 0)
        {
            if (first == null) // scenario where there are no nodes at all
            {
                newNode.prev = null;
                newNode.next = null;
                first = newNode;
            }
            else // first node is not null and the new node need to be inserted before first
            {
                newNode.prev = first.prev;
                newNode.next = first;
                first = newNode;
            }
        }
        else // scenarios where position is not 0
        {
            if (first == null) // scenario where there are no nodes at all
            {
                newNode.prev = null;
                newNode.next = null;
                first = newNode;
            }
            else
            {
                DoubleNode temp = first;

                // move the pointer to the desired position after which the new node needs to be inserted
                for (int i=0 ; i< position-1; i++)
                {
                    temp = temp.next;
                }

                // create links
                newNode.next = temp.next;
                newNode.prev = temp;

                // next node might be null , so check for this condition
                if (temp.next != null)
                {
                    temp.next.prev = newNode;
                }

                temp.next = newNode;
            }
        }
    }

    public static void deleteNode(int index)
    {
        if (index == 1)
        {
            DoubleNode temp = first;
            first = first.next;
            temp = null;
            if (first != null)
            {
                first.prev = null;
            }
        }
        else
        {
            DoubleNode temp = first;
            for (int i =0 ; i < index-1; i++)
            {
                temp = temp.next;
            }

            temp.prev.next = temp.next;
            if (temp.next != null)
            {
                temp.next.prev = temp.prev;
            }
            temp = null;
        }
    }

    public static void main(String[] args)
    {
        int[] arr  =  {5,10,20,30,40,50};

        create(arr, 5);
        System.out.println("Number of nodes : " + countNumberOfNodes(first));
        display(first);

//        insert(5, 0);
//        display(first);
//        System.out.println("Number of nodes after inserting before first node : " + countNumberOfNodes(first));


        insert(35, 4);
        System.out.println("Number of nodes post inserting after 4th node : " + countNumberOfNodes(first));
        display(first);

        deleteNode(6);
        System.out.println("Delete 4th node " );
        display(first);

        reverseDoublyLinkedList();
        display(first);
    }
}
