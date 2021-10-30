package leetcode;

public class RichestCustomer {

    /**
         Input: accounts = [[1,2,3],[3,2,1]]
         Output: 6
         Explanation:
         1st customer has wealth = 1 + 2 + 3 = 6
         2nd customer has wealth = 3 + 2 + 1 = 6
         Both customers are considered the richest with a wealth of 6 each, so return 6.
         * @param args
     */
    public static void main(String[] args)
    {
        int[][] accounts = {{1,2,3}, {3,2,1} };
        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {

        int maxWealth=0;

        for (int i=0; i<accounts.length; i++){
            int temp =0;
            for (int j=0; j<accounts[i].length; j++){
                temp = temp + accounts[i][j];
            }

            if (maxWealth < temp){
                maxWealth = temp;
            }
        }

        return maxWealth;
    }
}
