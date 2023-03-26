package sheetSolutions.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] is a subset of a1[] or not.
 Both the arrays can be sorted or unsorted. It may be assumed that elements in both array are distinct.
Example 1:

Input:
a1[] = {11, 1, 13, 21, 3, 7}
a2[] = {11, 3, 7, 1}
Output:
Yes
Explanation:
a2[] is a subset of a1[]
 */
public class FindIfArrayIsSubsetOfAnotherArray {
    // Approach 1 - Use hashing Time complexity:O(m+n), Space complexity:O(n)
    public static String isSubset(long[] a1, long[] a2) {
        Set<Long> hs = new HashSet<>();
        for (long x : a1) {
            hs.add(x); // add all elements of arr1
        }
        for (long y : a2) {
            if (!hs.contains(y)) { // check if hashmap contains all elements of arr2
                return "No";
            }
        }
        return "Yes";
    }
  /* Other approaches could be binary search and sorting . Or sorting and merging.Or we can compare the size of hashmap after
  adding all the elements of arr1 and arr 2 . If size remains same then arr2 is subset. These methods wil not be able to handle
  duplicates.
   */

    // Approach 2 - Use frequency table (works with duplicates) Time complexity:O(m+n)
    public static String isSubset2(long[] a1, long[] a2) {
        Map<Long, Integer> hs = new HashMap<>();
        for (long c : a1) { //
            // Increase the frequency of each element
            // in the frequency table.
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }
        for (long k : a2) {
            if (hs.getOrDefault(k, 0) > 0) {
        /* Decrease the frequency if the element was found in the frequency table with the frequency more than 0.else return 0 and
        if loop is completed return 1.
          */
                hs.put(k, hs.get(k) - 1);
            } else {
                return "No"; // if the freq is less element doesn't exist making the arr not a subset
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        long[] arr1 = {11, 1, 13, 21, 3, 7};
        long[] arr2 = {11, 3, 7, 1};
        System.out.println(isSubset(arr1, arr2));
        System.out.println(isSubset2(arr1, arr2));
    }
}
