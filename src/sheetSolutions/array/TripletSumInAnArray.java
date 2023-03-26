package sheetSolutions.array;

import java.util.Arrays;
import java.util.HashSet;

/*
Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet
 present in array, then print the triplet and return true. Else return false.

Examples:
Input: array = {12, 3, 4, 1, 6, 9}, sum = 24;
Output: 12, 3, 9
Explanation: There is a triplet (12, 3 and 9) present
in the array whose sum is 24.
Input: array = {1, 2, 3, 4, 5}, sum = 9
Output: 5, 3, 1
Explanation: There is a triplet (5, 3 and 1) present
in the array whose sum is 9.
 */
public class TripletSumInAnArray {
    /*
    Three approaches :
    1.Use three nested loops
    2.Use Hashing: Time Complexity:o(n^2) , Space complexity:O(n)
    3.Use sorting :Time Complexity:o(n^2) , Space complexity:O(1)
     */
    // Approach 2
  /*
      Algorithm:
  1.Traverse the array from start to end. (loop counter i)
  2.Create a HashMap or set to store unique pairs.
  3.Run another loop from i+1 to end of the array. (loop counter j)
  4.If there is an element in the set which is equal to x- arr[i] – arr[j], then print the triplet (arr[i], arr[j], x-arr[i]-arr[j]) and break
  Insert the jth element in the set.
       */
    public static boolean find3Numbers1(int[] A, int n, int X) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n - 2; i++) { // triplet will be found by running code in n-2 direction
            int curr_sum = X - A[i];
            for (int j = i + 1; j < n; j++) {
                if (hs.contains(curr_sum - A[j])) {
                    System.out.println("(" + A[i] + " " + A[j] + " " + (curr_sum - A[j]) + ")");
                    return true;
                }
                hs.add(A[j]); // to find if the no. was seen earlier
            }
        }
        return false;
    }

    // Approach 3
  /*
      Sort the given array.
  1.Loop over the array and fix the first element of the possible triplet, arr[i].
  2.Then fix two pointers, one at i + 1 and the other at n – 1. And look at the sum,
  3.If the sum is smaller than the required sum, increment the first pointer.
  4.Else, If the sum is bigger, Decrease the end pointer to reduce the sum.
  5.Else, if the sum of elements at two-pointer is equal to given sum then print the triplet and break.
       */
    public static boolean find3Numbers(int[] A, int n, int X) {

        // Your code Here
        Arrays.sort(A);
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            int x = A[i];
            while (l < r) {
                if (x + A[l] + A[r] == X) {
                    System.out.println("(" + A[l] + " " + A[r] + " " + x + ")");
                    l++;
                    r--;
                    found = true;
                } else if (x + A[l] + A[r] < X) {
                    l++;
                } else r--;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 1, 6, 9};
        System.out.println(find3Numbers1(arr, arr.length, 24));
        System.out.println(find3Numbers(arr, arr.length, 24));
    }
}
