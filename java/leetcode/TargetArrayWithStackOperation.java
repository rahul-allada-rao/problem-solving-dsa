package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import sun.tools.jconsole.Tab;

/**
 * Input: target = [1,3], n = 3
 Output: ["Push","Push","Pop","Push"]
 Explanation:
 Read number 1 and automatically push in the array -> [1]
 Read number 2 and automatically push in the array then Pop it -> [1]
 Read number 3 and automatically push in the array -> [1,3]
 */
public class TargetArrayWithStackOperation {

    public static class Stack{
        private int MAX_STACK_SIZE = 100;
        private int stack[] = new int[MAX_STACK_SIZE];
        private int top = -1;

        private boolean push(int x)
        {
            if (top >= (MAX_STACK_SIZE - 1)) {
                System.out.println("Stack Overflow");
                return false;
            }
            else {
                stack[++top] = x;
                System.out.println(x + " pushed into stack");
                return true;
            }
        }

        private int pop()
        {
            if (top < 0) {
                System.out.println("Stack Underflow");
                return 0;
            }
            else {
                int x = stack[top--];
                return x;
            }
        }

    }





    public static List<String> buildArray(int[] target, int n)
    {
        List<String> stackOperationList = new ArrayList<>();
        Stack stack = new Stack();

        for (int i = target.length -1 ; i >= 0 ; i--)
        {
            stack.push(target[i]);
        }

        boolean matchFound = true;
        int k = 1;

        for (int j = 1; j <= n; j++)
        {
            while( k <= target.length)
            {
                int poppedElement = matchFound ? stack.pop() : j;
                if (j == poppedElement)
                {
                    stackOperationList.add("Push");
                    matchFound = true;
                    k++;
                    break;
                }
                else
                {
                    stackOperationList.add("Push");
                    stackOperationList.add("Pop");
                    matchFound = false;
                    break;
                }
            }
        }

        return stackOperationList;
    }


    public static void main(String[] args)
    {
//        //--> ["Push","Push","Pop","Push"] OK
//        int[] target = new int[] {1, 3};
//        int n = 3;

        // ["Push","Push","Push"] --> OK
//        int[] target = new int[] {1, 2, 3};
//        int n = 3;

        // ["Push","Push"]
//        int[] target = new int[] {1, 2};
//        int n = 4;

        // ["Push","Pop","Push","Push","Push"]
//        int[] target = new int[] {2, 3, 4};
//        int n = 4;

        //["Push","Push"]
//        int[] target = new int[] {1,2};
//        int n = 4;


        // ["Push","Pop","Push","Push","Push","Push","Push","Pop","Push","Pop","Push","Push","Push"]
        // ["Push","Pop","Push","Push","Push","Push","Push","Pop","Push","Pop","Push","Push","Push"]
        int[] target = new int[] {2,3,4,5,8,9,10};
        int n = 10;

        List<String> stackOperationList  = buildArray(target, n);

        stackOperationList.forEach(System.out::println);
    }
}