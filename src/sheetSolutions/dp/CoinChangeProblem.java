package sheetSolutions.dp;
/*
Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM }
valued coins.
Example 1:

Input:
n = 4 , m = 3
S[] = {1,2,3}
Output: 4
Explanation: Four Possible ways are:
{1,1,1,1},{1,1,2},{2,2},{1,3}.
 */
public class CoinChangeProblem {
  /*
  To solve this problem the idea is whenever the sum value is greater than or equal to coin value we need to update the entry
  for that value else previous value in table was answer. We update by the rule : the previous value already for that entry is
   added with the table value at index of(sum value-coin value) .
   */

  public static long countWays(int[] S, int n, int m) {
    // Space complexity:O(n) , Time complexity :O(mn)
    long[] table = new long[n + 1]; // create a table with length one greater than sum value
    // base case when sum is 0 we have 1 way to make that sum i.e by not including any coin
    table[0] = 1;

    for (int i = 0; i < m; i++) { // for different types of coin
      for (int j = S[i]; j <= n; j++) { // for updating based on rule above
        table[j] += table[j - S[i]];
      }
    }
    return table[n]; // last value indicates no. of ways
  }

  public static void main(String[] args) {
    //
    int[] arr = {1, 2, 3};
    int m = arr.length;
    int n = 4;
    System.out.println(countWays(arr, n, m));
  }
}
