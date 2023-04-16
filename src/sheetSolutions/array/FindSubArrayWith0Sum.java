package sheetSolutions.array;
/*
Given an array of positive and negative numbers. Find if there is a sub array (of size at-least one) with 0 sum.

Example 1:

Input:
5
4 2 -3 1 6

Output:
Yes
Explanation:
2, -3, 1 is the sub array
with sum 0.
 */

import java.util.HashSet;
import java.util.Set;

public class FindSubArrayWith0Sum {

    static boolean findSum(int[] arr) {
    /*
    The idea is to iterate through the array and for every element arr[i], calculate the sum of elements from 0 to i
    (this can simply be done as sum += arr[i]). If the current sum has been seen before, then there is a zero-sum array.
    Hashing is used to store the sum values so that we can quickly store sum and find out whether the current sum is seen
    before or not. I don't know why we had to find if sum already exists.
     */
        int sum = 0;
        Set<Integer> hs = new HashSet<>();
        for (int i : arr) {
            sum += i;
            if (sum == 0 || i == 0 || hs.contains(sum)) { // check if sum is 0 or the element is 0 or set has seen the sum before
                return true; // there exists a sub array
            }
            hs.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-4, 1, 4, -1, 5};
        System.out.println(findSum(arr));
    }
}
