package algo.sort;

public class MergingOfSortedLists {

    public static void main(String[] args)
    {
        int[] firstList = {2,4,6,8,10,11};
        int[] secondList = {1,3,5,7,9};

        int[] finalList = merge(firstList, secondList);

        System.out.println("Expected : 1,2,3,4,5,6,7,8,9,10,11");
        System.out.print  ("Actual   : ");
        for (int element : finalList)
        {
            System.out.print(element + ",");
        }
    }

    private static int[] merge(int[] firstList, int[] secondList)
    {

        int sizeOfFirstList = firstList.length;
        int sizeOfSecondList = secondList.length;

        int i=0, j=0, k=0;
        int[] finalList = new int[sizeOfFirstList+sizeOfSecondList];

        // below code populates the final sorted list after comparing the elements from first and second list
        while(i < sizeOfFirstList && j < sizeOfSecondList)
        {
            if (firstList[i] < secondList[j])
            {
                finalList[k++] = firstList[i++];
            }
            else
            {
                finalList[k++] = secondList[j++];
            }
        }

        // below code populates the final sorted list with any leftover elements from first list
        for (; i < sizeOfFirstList ; i++)
        {
            finalList[k++] = firstList[i];
        }

        // below code populates the final sorted list with any leftover elements from second list
        for (; j < sizeOfSecondList ; j++)
        {
            finalList[k++] = secondList[j];
        }

        return finalList;
    }
}
