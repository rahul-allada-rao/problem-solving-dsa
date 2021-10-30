package ds.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShiftArray {

    public static void leftShift(int numOfLeftShifts, int[] arr){

        int firstElement = arr[0];
        for (int i=0; i < arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = firstElement;
    }

    public static void display(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print("\t" + arr[i]);
        }
    }

    public static void main(String[] args)
    {
//        int[] arr = {1,2,3,4,5};
//        display(arr);
//        leftShift(1, arr);
//        System.out.println();
//        display(arr);

//        int[] missArray = {1,2,3,4,5,7,8,9,10};
//        findMissingElementsInASortedArray(missArray);


        int[] missArray2 = {1,2,3,4,5,8,9,10,13,14,15};
        findMissingElementsInASortedArray(missArray2);
    }

    public static void findMissingElementsInASortedArray(int[] arr){

//        // method 1
//        for (int i=0; i< arr.length-1; i++){
//            if (arr[i+1] != arr[i]+1){
//                System.out.println(arr[i]+1);
//            }
//        }

        // method 2
        int diff = arr[0]-0;
        List<Integer> missedElements = new LinkedList<>();
        for (int i=0; i< arr.length-1; i++){

            if (arr[i+1] - arr[i] != diff){

                while (diff < arr[i+1] - arr[i]){
                    missedElements.add(arr[i]+diff);
                    diff++;
                }
                diff = arr[i+1] - arr[i];
            }
        }

        missedElements.forEach(System.out::println);
    }
}
