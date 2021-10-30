package multithreading;

 public class MySynchronizedData implements DataInterface
{
    // synchronized can be used at the method level or as a block as shown below
    public void display(String str)
    {
        synchronized (this)
        {
            for (int i=0; i< str.length(); i++)
            {
                System.out.print(str.charAt(i));
            }
        }
    }
}
