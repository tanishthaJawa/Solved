package sheetSolutions.array;
// Program to return min and max from an array in min no of comparisons
public class minMax {
  // to return two values from a method
  static class pair {
    int min;
    int max;
  }

  static pair getMinMax(int[] ar) {
    // linear approach
    pair minmax = new pair();
    int i;
    // if array consists of one element
    if (ar.length == 1) {
      minmax.max = ar[0];
      minmax.min = ar[0];
    }
    // If there are more than one element, then initialize min and max
    if (ar[0] < ar[1]) {
      minmax.min = ar[0];
      minmax.max = ar[1];
    } else {
      minmax.min = ar[1];
      minmax.max = ar[0];
    }

    for (i = 2; i < ar.length; i++) {
      if (minmax.max < ar[i]) {
        minmax.max = ar[i];
      } else if (minmax.min > ar[i]) {
        minmax.min = ar[i];
      }
    }
    return minmax;
  }

  static pair getMinMax(int[] ar, int low, int high) {
    // tournament method .worst number of comparisons=2(n-2)+1
    /* use divide and conquer approach .Best comparisons 1+n-2 */
    pair minMax2 = new pair();
    pair mml;
    pair mmr;

    if (low == high) {
      minMax2.max = ar[low];
      minMax2.min = ar[low];
      return minMax2;
    }
    if (high == low + 1) {
      if (ar[low] < ar[high]) {
        minMax2.min = ar[low];
        minMax2.max = ar[high];
      } else {
        minMax2.min = ar[high];
        minMax2.max = ar[low];
      }
      return minMax2;
    }
    int mid = (low + high) / 2;
    mml = getMinMax(ar, low, mid);
    mmr = getMinMax(ar, mid + 1, high);

    // find min and max from the sub arrays
    if (mml.min > mmr.min) {
      minMax2.min = mmr.min;
    } else {
      minMax2.min = mml.min;
    }
    if (mml.max < mmr.max) {
      minMax2.max = mmr.max;
    } else {
      minMax2.max = mml.max;
    }
    return minMax2;
  }

  static pair getMinMax(int[] ar, int n) {
    /* compare numbers for min and max using pairs*/
    pair minMax3 = new pair();
    int i;
    /* if array contains even no. of elements we find min and max from first and second elements of array
    and initialize the min and max. But when array has odd no. of elements we set min and max to first element
    only.This is done to ensure that we always compare elements in pair .
     */
    if (n % 2 == 0) {
      if (ar[0] < ar[1]) {
        minMax3.min = ar[0];
        minMax3.max = ar[1];
      } else {
        minMax3.min = ar[1];
        minMax3.max = ar[0];
      }
      i = 2;
    } else {
      minMax3.min = ar[0];
      minMax3.max = ar[0];
      i = 1;
    }
    /* we set value of i to 1 in odd so that we don't end up with array index out of bounds exception
    when comparing values with i+1. this ensures we compare in pairs/
     */
    while (i < n - 1) {
      if (ar[i] > ar[i + 1]) {
        if (ar[i] > minMax3.max) {
          minMax3.max = ar[i];
        }

        if (ar[i + 1] < minMax3.min) {
          minMax3.min = ar[i + 1];
        }
      } else {
        if (ar[i + 1] > minMax3.max) {
          minMax3.max = ar[i + 1];
        }

        if (ar[i] < minMax3.min) {
          minMax3.min = ar[i];
        }
      }
      i += 2;
    }
    return minMax3;
  }

  public static void main(String[] args) {
    int[] ar = {2, 4, 8, 1000, 1, 6, 9, 3};
    pair minMax = getMinMax(ar);
    System.out.println(minMax.min);
    System.out.println(minMax.max);
    pair minMax2 = getMinMax(ar, 0, 6);
    System.out.println(minMax2.min);
    System.out.println(minMax2.max);
    pair minMax3 = getMinMax(ar, ar.length);
    System.out.println(minMax3.min);
    System.out.println(minMax3.max);
  }
}
