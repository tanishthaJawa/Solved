package sheetSolutions.array;

/*
Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is divided into
three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified array.
Example 1:

Input:
n = 5
A[] = {1, 2, 3, 3, 4}
[a, b] = [1, 2]
Output: 1
Explanation: One possible arrangement is:
{1, 2, 3, 3, 4}. If you return a valid
arrangement, output will be 1.
 */
public class ThreeWayPartition {
    /*
    We traverse given array elements from left. We keep track of two pointers, first (called start in below code) to store next
    position of smaller element (smaller than range) from beginning; and second (called end in below code) to store next position of
     greater element from end.
     */
    public static void threeWayPartition(int[] arr, int lowVal, int highVal) {
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            // If current element is smaller than
            // range, put it on next available smaller
            // position.
            if (arr[i] < lowVal) {
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
                low++;
                i++;
            } else if (arr[i] > highVal) {
                // If current element is greater than
                // range, put it on next available greater
                // position.
                int temp = arr[high];
                arr[high] = arr[i];
                arr[i] = temp;
                high--; // here we do not increment i value because
                // we don't know if swapped value is smaller or not(where should it be placed)
            } else i++;
        }
    }
}
