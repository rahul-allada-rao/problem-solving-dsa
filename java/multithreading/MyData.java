package multithreading;

public class MyData implements DataInterface
{
    public void display(String str)
    {
        for (int i=0; i< str.length(); i++)
        {
            System.out.print(str.charAt(i));
        }
    }
}
