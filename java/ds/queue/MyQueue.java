package ds.queue;

public class MyQueue
{
    private static int front = -1;
    private static int rear = -1;
    private static int[] queue ;
    private static int SIZE;

    public MyQueue(int size)
    {
        SIZE = size;
        queue = new int[size];
    }

    public void enqueue(int element)
    {
        if (!isFull())
        {
            rear++;
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
            front++;
            value = queue[front];
        }

        return value;
    }

    public boolean isFull()
    {
        return rear == SIZE - 1;
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
        for (int i = front+1; i<= rear; i++)
        {
            System.out.print("\t" + queue[i]);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5};
        MyQueue myQueue = new MyQueue(array.length);

        for (int j=0; j < array.length; j++)
        {
            myQueue.enqueue(array[j]);
        }

        System.out.println("Count : " + myQueue.numberOfElements());
        displayElements();
        System.out.println("First Element : " + myQueue.firstElement());
        System.out.println("Last Element : " + myQueue.lastElement());

        myQueue.enqueue(11);

        System.out.println("Dequeqing : " + myQueue.dequeue());
        System.out.println("Dequeqing : " + myQueue.dequeue());
        System.out.println("Dequeqing : " + myQueue.dequeue());
        System.out.println("Dequeqing : " + myQueue.dequeue());
        System.out.println("Dequeqing : " + myQueue.dequeue());
        System.out.println("Dequeqing : " + myQueue.dequeue());
    }
}
