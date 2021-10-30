package multithreading;

public class MyThread1 extends Thread
{
    DataInterface myData;

    public MyThread1(DataInterface myData)
    {
        this.myData = myData;
    }

    public void run()
    {
        myData.display("Hello World ");
    }
}
