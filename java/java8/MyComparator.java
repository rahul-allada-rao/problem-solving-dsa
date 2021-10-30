package java8;

import java.util.Comparator;
import java.util.Optional;
import javax.swing.text.html.Option;

public class MyComparator implements Comparator<Object>{

    @Override
    public int compare(Object o1, Object o2)
    {
        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println(isIntegerNull(1));

    }


    private static boolean isIntegerNull(Integer val){

        // method 1 -> explicitly check for null values (ternary operator or its simplified version )
//        return (val == null) ? true : false;
//        return val == null;

        // method 2 -> Using Optional, if not null, return True,
        // else return Empty which can be checked further by isPresent()
        Optional<Integer> val2 = Optional.ofNullable(val);
        return val2.isPresent();
    }
}
