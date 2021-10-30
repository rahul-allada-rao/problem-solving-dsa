package collections.string;

public class MyString {

    public static void main(String[] args)
    {
        String var = "hello";
        System.out.println(var); // this prints "hello"
        stringChanged(var);
        System.out.println(var); // Strings are immutable, hence we won't be seeing "hello" changed to "Hello"!

        System.out.println(var.replace('h','X'));
        // but why the above code prints "Xello" --> internally a new memory is created for a new string with value "Xello"

        System.out.println(var); // this would still print "hello" since var is still pointing to the same memory location which has the value="hello"
    }

    private static void stringChanged(String x)
    {
        x= x.replace('h','H'); // when this happens a new memory gets created for "Hello"
        System.out.println(x); // this prints "Hello"
    }
}
