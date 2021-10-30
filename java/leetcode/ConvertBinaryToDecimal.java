package leetcode;


/**
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

 Return the decimal value of the number in the linked list.
 Input: head = [1,0,1]
 Output: 5
 Explanation: (101) in base 2 = (5) in base 10

 Here we have two subproblems:

 To parse non-empty linked list and to retrieve the digit sequence which represents a binary number.

 To convert this sequence into the number in decimal representation.

 The first subproblem is easy because the linked list is guaranteed to be non-empty.
 The second subproblem is to convert (101)_2(101)
 2
 ​
 into 1 \times 2^2 + 0 \times 2^1 + 1 \times 2^0 = 51×2
 2
 +0×2
 1
 +1×2
 0
 =5. It could be solved in two ways. To use classical arithmetic is more straightforward

 Approach 1: num = num * 2 + x

 Complexity Analysis

 Time complexity: \mathcal{O}(N)O(N).

 Space complexity: \mathcal{O}(1)O(1).
 */
public class ConvertBinaryToDecimal {


     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }



}

// the below code did not meet the time constraints

/**
 //         // collect all values from the head till null node into an array
 //         // run the conversion from binary to decimal
 //         // display/return the result

 //         // collect all values from the head till null node into an list
 //         LinkedList<Integer> binaryValues = new LinkedList<>();
 //         while(head.next != null){
 //             binaryValues.add(head.val);
 //             head = head.next;
 //         }

 //         int decimalNumber = convertIntoDecimal(binaryValues);

 //         return decimalNumber;

 }

 private int convertIntoDecimal(LinkedList<Integer> binaryNumber){
 int decimal = 0;
 int base = 1 ; //2^0
 for (int i = 0 ; i < binaryNumber.size() ; i++)
 {
 decimal = decimal + binaryNumber.get(i) * base;
 base = base * 2;
 }
 return decimal;
 }**/