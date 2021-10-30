package multithreading;

public class MyThread2 extends Thread
{
    DataInterface myData;

    public MyThread2(DataInterface myData)
    {
        this.myData = myData;
    }

    public void run()
    {
        myData.display("Welcome");
    }
}
