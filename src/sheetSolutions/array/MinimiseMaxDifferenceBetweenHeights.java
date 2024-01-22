package sheetSolutions.array;

import java.util.Arrays;

/*
Given an array arr[] denoting heights of N towers and a positive integer K.

For each tower, you must perform exactly one of the following operations exactly once.
Increase the height of the tower by K
Decrease the height of the tower by K
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each
tower.

Example 1:
Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as
{3, 3, 6, 8}. The difference between
the largest and the smallest is 8-3 = 5.
 */
public class MinimiseMaxDifferenceBetweenHeights {
    /*
    The idea is to add k to all the elements before partition and subtract k from elements after partition. We partition at
    every element.
     */
    public static int minimiseDifference(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int minimumDifference = arr[n - 1] - arr[0]; // initial Difference

        int currMin, currMax;
        for (int idx = 1; idx < n; idx++) {
            if (arr[idx] < k) {
                continue; // so that we do not end up having negative value at partition
            }
            currMin = Math.min(arr[0] + k, arr[idx] - k);
            currMax = Math.max(arr[idx - 1] + k, arr[n - 1] - k);
            minimumDifference = Math.min(minimumDifference, currMax - currMin);
        }
        return minimumDifference;
    }

    public static void main(String[] args) {
        System.out.println(minimiseDifference(new int[]{1, 5, 8, 10}, 4, 2));
    }
}
