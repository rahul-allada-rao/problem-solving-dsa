package leetcode;

public class ValidParentheses
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
            return charArray.length;
        }
    }

    public static void main(String[] args)
    {
//        MyStack myStack = new MyStack();
//
//        System.out.println("Testing if empty stack or not !!! Attempting to pop now on empty stack");
//        myStack.pop();
//
//        myStack.push('A');
//        myStack.push('B');
//        myStack.push('C');
//        myStack.push('D');
//        myStack.push('E');
//
//        System.out.println("Testing if full stack or not !!! Attempting to push now on full stack");
//        myStack.push('F');
//
//        System.out.println("Print all elements of the stack");
//        for (int i =0 ; i < myStack.size(); i++)
//        {
//            System.out.println(myStack.pop());
//        }
//        String s1 = "([)]"; //"{[]}";
//        System.out.println("Given string : " + s1);
//        System.out.println("Are parenthesis matching? " + isValid(s1));


        String s2 = "[[[]"; //"()[]{}"; //"(){}}{";
        System.out.println("Given string : " + s2);
        System.out.println("Are parenthesis matching? " + isValidPerfect(s2));

    }

    // accepted by leetcode
    public static boolean isValidPerfect(String s)
    {
        // convert string into char array
        char[] charArray = s.toCharArray();

        // if the string is not even then its definite that the parenthesis are not matching
        if (charArray.length % 2 != 0)
        {
            return false;
        }

        boolean isParenthesisMatching = false;
        MyStack myStack = new MyStack();

        // push the first character
        myStack.push(charArray[0]);

        // loop through the rest of the character array, if the opening and closing braces match, then pop from stack
        // and set isParenthesisMatching = true; else keep adding to the stack and set isParenthesisMatching=false
        for (int i=1; i<charArray.length ; i++)
        {
            if (!myStack.isEmpty() &&
                    (charArray[i] == ')' && myStack.peek() == '(')
                    || (charArray[i] == ']' && myStack.peek() == '[')
                    || (charArray[i] == '}' && myStack.peek() == '{') )
            {
                myStack.pop();
            }
            else
            {
                myStack.push(charArray[i]);
            }
        }

        // if the stack is not empty by now, then there are still unmatched parenthesis
        isParenthesisMatching = myStack.isEmpty() ? true : false;

        return isParenthesisMatching;
    }

//    public static boolean isValidNew(String s)
//    {
//        // convert string into char array
//        char[] charArray = s.toCharArray();
//
//        // if the string is not even then its definite that the parenthesis are not matching
//        if (charArray.length % 2 != 0)
//        {
//            return false;
//        }
//
//        boolean isParenthesisMatching = false;
//
//        for (int i= charArray.length/2-1 ; i > 0 ; i--)
//        {
//            for (int j = charArray.length/2  ; i < charArray.length ; j++ )
//            {
//                if ( (charArray[i] == '(' && charArray[j] == ')')
//                        || (charArray[i] == '[' && charArray[j] == ']')
//                        || (charArray[i] == '{' && charArray[j] == '}') )
//                {
//                    isParenthesisMatching = true;
//                    break;
//                }
//                else
//                {
//                    isParenthesisMatching = false;
//                    break;
//                }
//            }
//        }
//
//        return isParenthesisMatching;
//    }
//
//    public static boolean isValid(String s)
//    {
//        // convert string into char array
//        char[] charArray = s.toCharArray();
//
//        // if the string is not even then its definite that the parenthesis are not matching
//        if (charArray.length % 2 != 0)
//        {
//            return false;
//        }
//
//        // initialize two objects of stack
//        MyStack myStackLeft = new MyStack();
//        MyStack myStackRight = new MyStack();
//
//        // push first of characters into the left stack
//        for (int i=0; i<charArray.length/2 ; i++)
//        {
//            myStackLeft.push(charArray[i]);
//        }
//
//        // push second of characters into the left stack in reverse order
//        // this is done to ensure that while popping we are trying to balance against the parenthesis in the correct order
//        for (int i=charArray.length - 1 ; i>= charArray.length/2 ; i--)
//        {
//            myStackRight.push(charArray[i]);
//        }
//
//        boolean isParenthesisMatching = false;
//
//        // loop and pop through both the stacks
//        // balance the popped characters
//        while (!myStackLeft.isEmpty() && !myStackRight.isEmpty())
//        {
//            char leftPop = myStackLeft.pop();
//            char rightPop = myStackRight.pop();
//
//            if ( (leftPop == '(' && rightPop == ')')
//                || (leftPop == '[' && rightPop == ']')
//                || (leftPop == '{' && rightPop == '}') )
//            {
//                isParenthesisMatching = true;
//            }
//            else
//            {
//                isParenthesisMatching = false;
//                break;
//            }
//        }
//
//        return isParenthesisMatching;
//    }
}

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

/* Wrong solution
int countOfLeftRoundBracket =0;
        int countOfRightRoundBracket =0;

        int countOfLeftSquareBracket =0;
        int countOfRightSquareBracket =0;

        int countOfLeftFlowerBracket =0;
        int countOfRightFlowerBracket =0;

        while (!myStack.isEmpty())
        {
            char compareChar = myStack.pop();

            if (compareChar == '(')
            {
                countOfLeftRoundBracket++;
            }
            else if (compareChar == ')')
            {
                countOfRightRoundBracket++;
            }
            else if (compareChar == '[')
            {
                countOfLeftSquareBracket++;
            }
            else if (compareChar == ']')
            {
                countOfRightSquareBracket++;
            }
            else if (compareChar == '{')
            {
                countOfLeftFlowerBracket++;
            }
            else if (compareChar == '}')
            {
                countOfRightFlowerBracket++;
            }
        }

        System.out.println("countOfLeftRoundBracket - " + countOfLeftRoundBracket);
        System.out.println("countOfRightRoundBracket - " + countOfRightRoundBracket);

        System.out.println("countOfLeftSquareBracket - " + countOfLeftSquareBracket);
        System.out.println("countOfRightSquareBracket - " + countOfRightSquareBracket);

        System.out.println("countOfLeftFlowerBracket - " + countOfLeftFlowerBracket);
        System.out.println("countOfRightFlowerBracket - " + countOfRightFlowerBracket);

        if ( (countOfLeftRoundBracket != countOfRightRoundBracket)
                || (countOfLeftSquareBracket != countOfRightSquareBracket)
                || (countOfLeftFlowerBracket != countOfRightFlowerBracket) )
        {
            return false;
        }
        else
        {
            return true;
        }
 */