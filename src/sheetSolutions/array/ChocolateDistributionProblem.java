package sheetSolutions.array;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet
 can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such
  that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is
minimum.

Example 1:

Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between
maximum chocolates and minimum chocolates
is 9 - 3 = 6 by choosing following M packets :
{3, 4, 9, 7, 9}.
 */
public class ChocolateDistributionProblem {
    /*
    Time complexity:O(n log n)
    The idea is to use sorting.
    A simple solution is to generate all subsets of size m of arr[0..n-1]. For every subset, find the difference between the maximum and
    minimum elements in it. Finally, return the minimum difference. An efficient solution is based on the observation that to
     minimize the difference, we must choose consecutive elements from a  sorted packet. We first sort the array arr[0..n-1], then
      find the sub array of size m with the minimum difference between the last and first elements.
     */
    static long findMinDiff(ArrayList<Long> a, long n, long m) {
        // if there are no chocolates(n) or number of students (m)is 0
        if (m == 0 || n == 0) {
            return 0;
        }
        Collections.sort(a);
        if (n < m) { // Number of students cannot be more than number of packets
            return -1;
        }
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            long diff = a.get(i + (int) m - 1) - a.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }
}
