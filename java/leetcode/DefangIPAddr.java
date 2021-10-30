package leetcode;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.

 A defanged IP address replaces every period "." with "[.]".
 */
public class DefangIPAddr
{
    public static String defangIPaddr(String address)
    {
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = address.toCharArray();

        for (int i =0 ; i< charArray.length; i++)
        {
            String newStr = charArray[i] == '.' ? "[.]" : String.valueOf(charArray[i]);


            stringBuilder.append(newStr);
        }
            return stringBuilder.toString();

        // below code is using replace function
//        String newString = address.replace(".", "[.]");
//        return newString;
    }

    public static void main(String[] args)
    {
        String addr = "1.1.1.1";
        String newAddr = defangIPaddr(addr);
        System.out.println(newAddr);

        int value = 'A';
        System.out.println("ASCII value of A : " + (int)'A');
        System.out.println("Char value of 1 : " + value);
    }
}
