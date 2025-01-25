package sheetSolutions.dp;

/*
Given two strings s1 and s2, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.

A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "ABE" is a subsequence of "ABCDE".

Examples:

Input: s1 = "ABCDGH", s2 = "AEDFHR"
Output: 3
Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a length of 3.
 */
public class LongestCommonSubsequence {

    static int lcsRecursive(String s1, String s2, int m, int n) {
        // your code here
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcsRecursive(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcsRecursive(s1, s2, m - 1, n), lcsRecursive(s1, s2, m, n - 1));
        }
    }

    static int lcsMemoized(String s1, String s2) {
        // your code here
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcsHelper(s1, s2, m, n, dp);
    }

    static int lcsHelper(String s1, String s2, int m, int n, int[][] dp) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + lcsHelper(s1, s2, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(lcsHelper(s1, s2, m - 1, n, dp), lcsHelper(s1, s2, m, n - 1, dp));
        }
        return dp[m][n];
    }

    static int lcsTabulated(String s1, String s2) {
        // your code here
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
