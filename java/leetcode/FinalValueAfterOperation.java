package leetcode;

public class FinalValueAfterOperation {

    public static int finalValueAfterOperations(String[] operations) {

        int x=0;

        for (int i=0; i< operations.length; i++){

            if (operations[i].contains("--")){
                x = x - 1;
            }
            else if (operations[i].contains("++")){
                x = x + 1;
            }
        }

        return x;

    }
    /*
        Input: operations = ["--X","X++","X++"]
        Output: 1
        Explanation: The operations are performed as follows:
        Initially, X = 0.
        --X: X is decremented by 1, X =  0 - 1 = -1.
        X++: X is incremented by 1, X = -1 + 1 =  0.
        X++: X is incremented by 1, X =  0 + 1 =  1.
     */
    public static void main(String[] args)
    {
        String[] strings = {"--X","X++","X++"};
        System.out.println(finalValueAfterOperations(strings));
    }
}
