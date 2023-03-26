package sheetSolutions.array;

import java.util.Scanner;

/*
@author tanishtha

 */
public class cyclicRotation {
    // store first element in variable and shift each element then replace first element with variable
    // value
    static void rotate(int[] ar) {
        int x = ar[ar.length - 1];
        for (int i = ar.length - 1; i > 0; i--) {
            ar[i] = ar[i - 1];
        }
        ar[0] = x;
    }

    static void rotate1(int[] ar) {
        // use two pointers i and j .swap elements of i and j. keep i moving and j fixed.
        int i, j = ar.length - 1;
        for (i = 0; i < ar.length; i++) {
            int temp = ar[j];
            ar[j] = ar[i];
            ar[i] = temp;
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
        rotate1(ar);
        printArray(ar);
    }
}
