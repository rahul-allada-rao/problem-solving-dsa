package algo.search;

public class BinarySearch {

    /*
            1. Assumption = All elements should be sorted
            2. Need three variables - low, high, mid
            3. mid = (low + high)/2 -> take the floor value
            4. if key == element at mid, then found, return the index
            5. if key > mid -> low = mid+1, high = high, repeat
            6. if key < mid -> low = low, high = mid-1, repeat
            7. if low > high --> this means that key is not found
     */

    public static int binarySearch(int low, int high, int key, int[] arr)
    {
        if (low > high)
        {
            System.out.println("Key " + key + " not found!");
            return -1;
        }

        int mid = (low + high)/2;
        int index = 0;

        if (key == arr[mid])
        {
            System.out.println("Key " + key + " found at index: " + mid);
            return mid;
        }
        else if (key > arr[mid])
        {
            low = mid+1;
            index =  binarySearch(low, high, key, arr);
        }
        else if (key < arr[mid])
        {
            high = mid-1;
            index = binarySearch(low, high, key, arr);
        }

        return index;
    }

    public static void main(String[] args)
    {
        int[] arr = {4,8,10,15,18,21,24,27,29,33,34,37,39,41,43};
        int index = binarySearch(0, 14, 100, arr);
    }
}

