package problems;

import java.util.Arrays;

/*
You are given the weights and values of items, and you need to put these items in a knapsack of capacity to achieve the maximum total value in the knapsack. Each item is available in only one quantity.

In other words, you are given two integer arrays val[] and wt[], which represent the values and weights associated with items, respectively. You are also given an integer capacity, which represents the knapsack capacity. Your task is to find the maximum sum of values of a subset of val[] such that the sum of the weights of the corresponding subset is less than or equal to capacity. You cannot break an item; you must either pick the entire item or leave it (0-1 property).

Examples :

Input: capacity = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
 */
public class knapSack {

    // Approach 1 - recursive may cause stack out of memory o(n2) tc:
    static int knapSackRecursive(int W, int[] wt, int[] val, int n) {
        // Base Case
        if (n == 0 || W == 0) return 0;

        // If weight of the nth item is
        // less than Knapsack capacity W,
        // then this item can be included or excluded
        // in the optimal solution
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapSackRecursive(W - wt[n - 1], wt, val, n - 1), knapSackRecursive(W, wt, val, n - 1));
        } else {
            return knapSackRecursive(W, wt, val, n - 1);
        }

    }

    // Approach 2 memoization - may cause stack overflow O(n x W) Time and Space
    static int knapSackMemoized(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        knapSackHelper(W, wt, val, n, dp);
        return dp[n][W];
    }

    static int knapSackHelper(int W, int[] wt, int[] val, int n, int[][] dp) {
        if (n == 0 || W == 0) return 0;
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max(val[n - 1] + knapSackHelper(W - wt[n - 1], wt, val, n - 1, dp), knapSackHelper(W, wt, val, n - 1, dp));
        } else {
            dp[n][W] = knapSackHelper(W, wt, val, n - 1, dp);
        }

        return dp[n][W];

    }

    // Approach 3 - tabulation approach O(n x W) Time and Space
    static int knapSackBottomUp(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (wt[i - 1] <= j) dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }

}
