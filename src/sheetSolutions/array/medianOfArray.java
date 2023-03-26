package sheetSolutions.array;

import java.util.Arrays;

/*
In the question list it is named as median of two array of same size.
This problem aims to find median in an array. If it has even no. of elements median is average of two middle elements else
middle element is average
 */
public class medianOfArray {
    public static int find_median(int[] v) {
        // Code here
        Arrays.sort(v); // Array is sorted
        int i;
        if (v.length % 2 != 0) { // if arr has odd no. of elements
            i =
                    (v.length)
                            / 2; // here because arr indexing starts from 0 ,formula(n+1)/2 is replaced with n/2
            return v[i];
        } else {
            i = v.length / 2; // if even no. of elements
            return (v[i] + v[i - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {56, 79, 81, 23};
        System.out.println(find_median(arr));
    }
}
