import java.util.Arrays;

/*
Perfect Sum Problem
Difficulty: MediumAccuracy: 20.58%Submissions: 456K+Points: 4
Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.

Examples:

Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
Output: 3
Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
 */
public class Main {

    static int countSubSets(int[] arr, int target){
        return countSubsetsHelper(0,0,arr, target);
    }

    private static int countSubsetsHelper(int i, int currSum, int[] arr, int target) {
        int n =arr.length;
        if(i==n){
            return currSum == target? 1:0;
        }
        int exclude = countSubsetsHelper(i+1,currSum,arr, target);
        int include =0;
        if(arr[i]+currSum<=target){
            include = countSubsetsHelper(i+1,currSum+arr[i], arr, target);
        }
        return include+exclude;
    }

    // Function to recursively count
    // subsets with a given sum using memoization
    static int countSubsetsMemoized(int i, int currentSum, int target,
                            int[] arr, int[][] dp) {
        int n = arr.length;

        // Base case: If we've processed all elements in the array
        if (i == n)

            // Return 1 if the current subset's sum
            // equals the target, else return 0
            return (currentSum == target) ? 1 : 0;

        // Check if the result for the current state
        // is already computed
        if (dp[i][currentSum] != -1)
            return dp[i][currentSum];

        // Case 1: Exclude the current element
        int exclude = countSubsetsMemoized(i + 1, currentSum, target, arr, dp);

        // Case 2: Include the current element
        int include = 0;
        if (currentSum + arr[i] <= target)
            include = countSubsetsMemoized(i + 1, currentSum + arr[i],
                    target, arr, dp);

        // Store the result in the memoization
        // table and return it
        dp[i][currentSum] = include + exclude;
        return dp[i][currentSum];
    }

    // Function to initiate the recursive subset count
    static int perfectSum(int[] arr, int target) {
        int n = arr.length;

        // Initialize a 2D memoization table with -1
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return countSubsetsMemoized(0, 0, target, arr, dp);
    }

    public int perfectSumDynamicProgramming(int[] arr, int target) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            // Going from 0 because of 0 inputs. This will cause the 0 subsets to be included.
            for (int j = 0; j <= target; j++) {
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        return dp[n][target];
    }
}
