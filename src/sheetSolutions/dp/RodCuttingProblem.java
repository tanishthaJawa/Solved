/*
Given a rod of length n(size of price) inches and an array of prices, price. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Example:

Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.
 */
public class RodCuttingProblem {

    public int cutRod(int[] price) {
        // code here
        int len = price.length;
        int[] rodLen = new int[len];

        for (int i = 0; i < len; i++) {
            rodLen[i] = i + 1;
        }

        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (rodLen[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - rodLen[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len][len];
    }
}
