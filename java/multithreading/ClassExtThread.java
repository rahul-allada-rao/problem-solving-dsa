package multithreading;

public class ClassExtThread extends Thread
{
    public void run()
    {
        for (int i=0 ; i<5 ; i++)
        {
            System.out.println("\n Hello");
        }
    }

    public static void main(String[] args)
    {
        ClassExtThread obj = new ClassExtThread();
        obj.start();

        for (int j = 0 ; j < 10 ; j++)
        {
            System.out.println("\n World");
        }
    }
}
