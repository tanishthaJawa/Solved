package sheetSolutions.array;

import java.util.Scanner;
/*
This program sorts an array of 0s ,1s,2s without using any sorting algorithms

Approach:
Keep three indices low = 1, mid = 1 and high = N and there are four ranges, 1 to low (the range containing 0),
 low to mid (the range containing 1), mid to high (the range containing unknown elements) and high to N
 (the range containing 2).
Traverse the array from start to end and mid is less than high. (Loop counter is i)
If the element is 0 then swap the element with the element at index low and update low = low + 1 and mid = mid + 1
If the element is 1 then update mid = mid + 1
If the element is 2 then swap the element with the element at index high and update high = high – 1 and update
 i = i – 1. As the swapped element is not processed
 */

public class sortArrayOf0s1s2s {

  static void sort(int[] ar) {
    int low = 0, mid = 0, high, temp;
    high = ar.length - 1;
    while (mid <= high) {
      switch (ar[mid]) {
        case 0:
          temp = ar[mid];
          ar[mid] = ar[low];
          ar[low] = temp;
          low++;
          mid++;
          break;
        case 1:
          mid = mid + 1;
          break;
        case 2:
          temp = ar[mid];
          ar[mid] = ar[high];
          ar[high] = temp;
          high--;
          break;
      }
    }
  }

  static void sort1(int[] ar) {
    int c0 = 0, c1 = 0, c2 = 0;
    for (int j : ar) {
      switch (j) {
        case 0:
          c0++;
          break;
        case 1:
          c1++;
          break;
        case 2:
          c2++;
          break;
      }
    }
    int k = 0;
    while (c0 > 0) {
      ar[k++] = 0;
      c0--;
    }
    while (c1 > 0) {
      ar[k++] = 1;
      c1--;
    }
    while (c2 > 0) {
      ar[k++] = 2;
      c2--;
    }
  }

  static void printArray(int[] ar) {
    for (int j : ar) {
      System.out.print(j + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n;
    System.out.println("Enter the size of array");
    n = in.nextInt();
    int[] ar = new int[n];
    System.out.println("Enter the elements of array");
    for (int k = 0; k < n; k++) {
      ar[k] = in.nextInt();
    }
    printArray(ar);
    sort1(ar);
    printArray(ar);
  }
}
