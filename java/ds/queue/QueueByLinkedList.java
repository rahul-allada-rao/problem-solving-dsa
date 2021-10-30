package ds.queue;

import ds.linkedlist.MyLinkedList;

public class QueueByLinkedList
{
    public static class Node
    {
        int data;
        Node next;
    }


    // initial condition --> point both front and rear to null, i.e there are no nodes in this queue
    // In Queue -- rear is used for insertion (enqueue), front is used for deletion (dequeue)
    private static Node front = null;
    private static Node rear = null;

    public static void enqueue(int val)
    {
        Node temp = new Node();
        if (temp == null)
        {
            System.out.println("Queue is full");
        }
        else
        {
            temp.data = val;
            temp.next = null;

            if (front == null) // if its the very first node, then make both front and rear point to the new node created
            {
                front = rear = temp;
            }
            else // its not the first node, so insert it at the rear end following FIFO principle
            {
                // point current rear's next to the newly created node
                rear.next = temp;
                // move rear to point to the new node created
                rear = temp;
            }
        }
    }

    public static int dequeue()
    {
        int value = -1;
        Node temp = null;

        if (front == null)
        {
            System.out.println("Queue is empty, nothing to dequeue !!!");
        }
        else
        {
            temp = front;
            front = front.next; // move front to the next node
            value = temp.data; // set the value to current front node's data
            temp = null; // free the space for this node
        }
        return value;
    }

    public static void display()
    {
        Node temp = front;

        while (temp != null)
        {
            System.out.print("\t" + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Enqueue 5 elements");
        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);

        System.out.println("\nDisplay....");
        display();

        System.out.println("\nDequeue 3 elements....");
        dequeue();
        dequeue();
        dequeue();

        System.out.println("\nDisplay....");
        display();


        System.out.println("\nDequeue 3 more elements....");
        dequeue();
        dequeue();
        dequeue();

        System.out.println("\nDisplay....");
        display();

    }
}
