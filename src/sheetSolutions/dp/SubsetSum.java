

import java.util.Arrays;

/*
Given an array of positive integers arr[] and a value target, determine if there is a subset of the given array with sum equal to given target.

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], target = 9
Output: true
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9. */
public class SubsetSum {

    // Approach 1 - recursive may cause stack out of memory o(n2) tc:
    static boolean isSubsetSumRecursive(int target, int[] arr, int n) {
        // Base Case
        // if target is 0 we can return an empty subset
        if (target == 0) {
            return true;
        }
        // if no elements in array
        if (n == 0) {
            return false;
        }

        // If element is less than target we can check if
        // then this element can be included or excluded
        // in the optimal solution and if subset is possible or not
        //  Check if sum can be obtained by including
        //  or excluding the last element
        if (arr[n - 1] <= target) {
            return isSubsetSumRecursive(target - arr[n - 1], arr, n - 1) || isSubsetSumRecursive(target, arr, n - 1);
        } else {
            return isSubsetSumRecursive(target, arr, n - 1);
        }

    }

    // Approach 2 memoization - may cause stack overflow O(n x W) Time and Space
    static boolean isSubsetSumMemoized(int target, int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return isSubsetSumHelper(target, arr, n, dp);
    }

    static boolean isSubsetSumHelper(int target, int[] arr, int n, int[][] dp) {
        if (target == 0) {
            return true;
        }
        // if no elements in array
        if (n == 0) {
            return false;
        }
        // If the value is already computed, return it
        if (dp[n][target] != -1) {
            return dp[n][target] == 1;
        }
        if (arr[n - 1] <= target) {
            dp[n][target] = isSubsetSumHelper(target - arr[n - 1], arr, n - 1, dp) || isSubsetSumHelper(target, arr, n - 1, dp) ? 1 : 0;
        } else {
            dp[n][target] = isSubsetSumHelper(target, arr, n - 1, dp) ? 1 : 0;
        }

        return dp[n][target] == 1;

    }

    // Approach 3 - tabulation approach O(n x W) Time and Space
    static boolean isSubsetSumBottomUp(int target, int[] arr) {
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

}
