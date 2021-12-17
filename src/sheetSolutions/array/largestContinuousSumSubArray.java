package sheetSolutions.array;
/*
@author tanishtha
 */

/* The idea here is:
Kadane’s Algorithm:

Initialize:
    max_so_far = INT_MIN
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
return max_so_far
Explanation:
The simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). Each time we get a positive-sum compare it with max_so_far and update max_so_far if it is greater than max_so_far


 */
public class largestContinuousSumSubArray {
  static int maxSum(int[] ar) {
    int max_so_far = Integer.MIN_VALUE;
    int max_end_here = 0, start = 0, end = 0, s = 0;
    for (int i = 0; i < ar.length; i++) {
      max_end_here = max_end_here + ar[i];
      if (max_so_far < max_end_here) {
        max_so_far = max_end_here;
        start = s;
        end = i; // keeps track of index of subarray
      }
      if (max_end_here < 0) {
        max_end_here = 0;
        s = i + 1;
      }
    }
    System.out.println("starting index:" + start);
    System.out.println("ending index:" + end);
    return max_so_far;
  }
  // reduced no. of comparisons
  static int maxSum1(int[] ar) {
    int max_so_far = ar[0];
    int max_end_here = 0;
    for (int i : ar) {
      max_end_here = max_end_here + i;
      if (max_end_here < 0) {
        max_end_here = 0;
      }
      /*
      check and compare only if max_end_here>0
       */
      else if (max_so_far < max_end_here) max_so_far = max_end_here;
    }
    return max_so_far;
  }

  static int maxSum2(int[] ar) {
    // can handle if array contains only negative numbers
    int local_max = ar[0];
    int global_max = ar[0];
    for (int x = 1; x < ar.length; x++) {
      local_max = Math.max(ar[x], local_max + ar[x]);
      global_max = Math.max(global_max, local_max);
    }
    return global_max;
  }

  static void printMax(int[] ar) {
    int ans = maxSum(ar);
    int ans1 = maxSum1(ar);
    int ans2 = maxSum2(ar);
    System.out.println("Max contiguous sum of subarray is:" + ans);
    System.out.println("Max contiguous sum of subarray is:" + ans1);
    System.out.println("Max contiguous sum of subarray is:" + ans2);
  }

  public static void main(String[] args) {
    int[] arr = {-1, -2, -3, -4};
    printMax(arr);
  }
}
