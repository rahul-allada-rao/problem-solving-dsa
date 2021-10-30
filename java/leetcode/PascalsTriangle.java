package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        list.add(1);
        finalList.add(list);

        if (numRows == 1)
        {
            return finalList;
        }

        int tempSum =0;

        for (int i=2; i<=numRows; i++)
        {
            List<Integer> tempList = new ArrayList<>();

            for (int j=0; j<i-2; j++)
            {
                tempSum = tempSum + finalList.get(i-2).get(j);
                tempList.add(tempSum);
            }

            finalList.add(tempList);
        }

        return finalList;
    }

    public static void main(String[] args)
    {
        List<List<Integer>> list1 = generate(1);
        list1.forEach(System.out::println);

        List<List<Integer>> list2 = generate(2);
        list2.forEach(System.out::println);

        List<List<Integer>> list3 = generate(5);
        list3.forEach(System.out::println);

    }
}
