

import java.util.Arrays;

/*
Given an array arr[], return true if it can be partitioned into two subsets such that the sum of elements in both parts is the same, otherwise, false.
Note: Each element is present in either the first subset or the second subset, but not in both.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11]. */
public class EqualSumPartition {
    static boolean equalPartition(int[] arr) {
        // code here
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) {
            return false;
        } else
            return isSubsetSum(arr, sum / 2);
    }

    static boolean isSubsetSum(int[] arr, int target) {
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


