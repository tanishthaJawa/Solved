package sheetSolutions.searchSort;

import java.util.Arrays;
/*
This program aims to find pair with difference
 */

public class findPairWithDifference {
  static boolean findPair(int[] arr, int n) {
    Arrays.sort(arr);
    int i = 0, j = 1;
    while (i < arr.length && j < arr.length) {
      if (i != j && (arr[i] - arr[j] == n || arr[j] - arr[i] == n)) {
        System.out.print("(" + arr[i] + " " + arr[j] + ")");
        return true;
      } else if (arr[j] - arr[i] < n) j++;
      else i++;
    }
    System.out.println("pair not found");
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {1, 8, 30, 40, 100};
    int n = -60;
    findPair(arr, n);
  }
}
