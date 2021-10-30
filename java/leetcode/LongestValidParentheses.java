package leetcode;

public class LongestValidParentheses
{
    public static class MyStack
    {
        private int MAX_STACK_SIZE = 10000;
        private int TOP_OF_STACK = -1;
        private char[] charArray = new char[MAX_STACK_SIZE];

        public char pop()
        {
            if (!isEmpty())
            {
                char var = charArray[TOP_OF_STACK];
                TOP_OF_STACK--;
                return var;
            }
            else
            {
                System.out.println("Stack underflow !!!");
                return 'X';
            }
        }

        public void push(char parenthesis)
        {
            if (!isFull())
            {
                TOP_OF_STACK++;
                charArray[TOP_OF_STACK] = parenthesis;
            }
            else
            {
                System.out.println("Stack overflow !!!");
            }
        }

        public char peek()
        {
            char var = 0;
            if (!isEmpty())
                var = charArray[TOP_OF_STACK];
            return var;
        }

        public boolean isEmpty()
        {
            return TOP_OF_STACK == -1;
        }

        public boolean isFull()
        {
            return TOP_OF_STACK == MAX_STACK_SIZE-1;
        }

        public int size()
        {
            return TOP_OF_STACK+1;
        }
    }

    public static void main(String[] args)
    {
        String s1 = "(()";
        System.out.println(s1 + " Exp 2, Actual Count = " + longestValidParentheses(s1));

        String s2 = ")()())";
        System.out.println(s2 + " Exp 4, Actual Count = " + longestValidParentheses(s2));

        String s3 = "";
        System.out.println(s3 + " Exp 0, Actual Count = " + longestValidParentheses(s3));


        String s4 = "()(()";
        System.out.println(s4 + " Exp 2, Actual Count = " + longestValidParentheses(s4));

        String s5 = ")()())";
        System.out.println(s5 + " Exp 4, Actual Count = " + longestValidParentheses(s5));

        String s6 = "()(())";
        System.out.println(s6 + " Exp 6, Actual Count = " + longestValidParentheses(s6));
    }


    // not working
    public static int longestValidParentheses(String s)
    {
        // convert string into char array
        char[] charArray = s.toCharArray();

        if (charArray.length == 0)
        {
            return 0;
        }

        MyStack myStack = new MyStack();

        int count=0;

        for (int i=0; i<charArray.length ; i++)
        {
            if (!myStack.isEmpty() &&
                    (myStack.peek() == '(' && charArray[i] == ')' ))
            {
                myStack.pop();
                count = count+2;
            }
            else
            {
                myStack.push(charArray[i]);
            }
        }

        return count;
    }
}

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.



Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.

 */
