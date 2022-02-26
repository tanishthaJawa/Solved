package sheetSolutions.searchSort;

import java.util.ArrayList;

public class valueEqualToIndexValue {
  static ArrayList<Integer> valueEqualToIndex(int[] arr, int n) {
    // code here
    ArrayList<Integer> output = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (arr[i] == i + 1) {
        output.add(arr[i]);
      }
    }
    return output;
  }

  public static void main(String[] args) {
    int[] ar = {1, 2, 3, 4, 8};
    System.out.println(valueEqualToIndex(ar, ar.length));
  }
}
