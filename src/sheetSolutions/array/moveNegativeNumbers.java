package sheetSolutions.array;

import java.util.Scanner;

/* This program moves negative number to the beginning without preserving order.The first approach is by using the
partition approach of quicksort algorithm.

@author tanishtha
 */
public class moveNegativeNumbers {
    static void rearrange(int[] ar) {
        // j is the beginning index to which we can shift
        int i, j = 0, temp;
        for (i = 0; i < ar.length; i++) {
            if (ar[i] < 0) {
                if (i != j) {
                    temp = ar[j];
                    ar[j] = ar[i];
                    ar[i] = temp;
                }
                j++;
            }
        }
    }

    static void rearrangeUsingTwoPointers(int[] ar) {
        int left = 0, right = ar.length - 1, temp;
        while (left < right) {
            // checks if left element is positive  and right element is negative
            if (ar[left] > 0 && ar[right] < 0) {
                temp = ar[right];
                ar[right] = ar[left];
                ar[left] = temp;
                left++;
                right--;
            }
            // check if both elements are negative
            else if (ar[left] < 0 && ar[right] < 0) {
                left++;
            }
            // check if both elements are positive
            else if (ar[left] > 0 && ar[right] > 0) {
                right--;
            } else {
                left++;
                right--;
            }
        }
    }

    static void rearrangeNumbersUsingDutchNationalFlagApproach(int [] ar){
        int low =0, high = ar.length -1;
        while(low<=high){
            if(ar[low] <= 0){
                low++;
            }
            else{
                swap(ar, low, high)
                high --;
            }
        }
    }

    static void swap(int [] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
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
        rearrange(ar);
        // rearrangeUsingTwoPointers(ar);
        printArray(ar);
    }
}
