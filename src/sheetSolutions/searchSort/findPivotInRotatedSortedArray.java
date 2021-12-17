package sheetSolutions.searchSort;
/*
Suppose we have a sorted array, and now we rotate it N times, find the pivot element.
The pivot element would be the largest element. Also, can you calculate N?
 */
public class findPivotInRotatedSortedArray {
  static void findPivot(int[] ar) {
    int low = 0, high = ar.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (ar[mid] > ar[high]) {
        low = mid + 1; // low returns element just after pivot i.e min element
      } else {
        high = mid;
      }
    }
    System.out.println("pivot:" + (low - 1));
    System.out.println("pivot rotated:" + low);
  }

  static int findPivot1(int[] ar, int low, int high, int lowerBound, int upperBound) {
    int mid = low + (high - low) / 2;
    if (mid == lowerBound) {
      if (mid == upperBound) { // only one element
        return mid;
      } else if (ar[mid] >= ar[mid + 1]) // mid is the greatest element
      return mid;
    } else if (mid == upperBound) {
      if (ar[mid] >= ar[mid - 1]) {
        return mid;
      }
    } else {
      if (ar[mid] >= ar[mid + 1] && ar[mid] >= ar[mid - 1]) {
        // Mid value is the pivot
        return mid;
      } else if (ar[mid] > ar[high]) {
        return findPivot1(ar, mid + 1, high, lowerBound, upperBound);
      } else if (ar[mid] < ar[high]) {
        return findPivot1(ar, low, mid - 1, lowerBound, upperBound);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] ar = {3, 4, 5, 6, 7, 0, 1, 2};
    findPivot(ar);
    System.out.println(findPivot1(ar, 0, ar.length - 1, 0, ar.length - 1));
  }
}
