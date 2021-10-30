package ds.queue;

public class MyCircularQueue
{
    private static int front = 0;
    private static int rear = 0;
    private static int[] queue ;
    private static int SIZE;

    public MyCircularQueue(int size)
    {
        SIZE = size;
        queue = new int[size];
    }

    public void enqueue(int element)
    {
        if (!isFull())
        {
            rear = (rear + 1) % SIZE ;
            queue[rear] = element;
        }
        else
        {
            System.out.println("Queue is full!");
        }
    }

    public int dequeue()
    {
        int value = -1;
        if (isEmpty())
        {
            System.out.println("Cannot delete, queue is empty !!!");
        }
        else
        {
            front = ( front + 1 ) % SIZE;
            value = queue[front];
        }

        return value;
    }

    public boolean isFull()
    {
        return (rear + 1) % SIZE == front;
    }

    public boolean isEmpty()
    {
        return front == rear;
    }

    public int firstElement()
    {
        return queue[front+1];
    }

    public int lastElement()
    {
        return queue[rear];
    }

    public int numberOfElements()
    {
        return rear+1;
    }

    public static void displayElements()
    {
        int i= front+1;
        do
        {
            System.out.print("\t" +queue[i]);
            i = ( i + 1 ) % SIZE;
        }
        while ( i != (rear +1) % SIZE ); // to display the last element
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] array = {0, 1,2,3,4};
        MyCircularQueue myQueue = new MyCircularQueue(array.length);

        for (int j=1; j < array.length; j++)
        {
            myQueue.enqueue(array[j]);
        }

        displayElements();
//        System.out.println("Count : " + myQueue.numberOfElements());
//        displayElements();
//        System.out.println("First Element : " + myQueue.firstElement());
//        System.out.println("Last Element : " + myQueue.lastElement());
//
//        myQueue.enqueue(11);
//
//        System.out.println("Dequeqing : " + myQueue.dequeue());
//        System.out.println("Dequeqing : " + myQueue.dequeue());
//        System.out.println("Dequeqing : " + myQueue.dequeue());
//
//        myQueue.enqueue(11);
//        myQueue.enqueue(12);
//
//        System.out.println("Count : " + myQueue.numberOfElements());
//        displayElements();
//        System.out.println("First Element : " + myQueue.firstElement());
//        System.out.println("Last Element : " + myQueue.lastElement());
    }
}
