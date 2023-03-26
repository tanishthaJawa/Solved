package sheetSolutions.array;

/*
This program determines the union and intersection of two sorted arrays.
@author tanishtha
 */
public class unionAndIntersection {

    static void union(int[] ar1, int[] ar2) {
    /*
    this method does not handle duplicates.O(m+n)
     */
        //        1) Use two index variables i and j, initial values i = 0, j = 0
        //        2) If arr1[i] is smaller than arr2[j] then print arr1[i] and increment i.
        //        3) If arr1[i] is greater than arr2[j] then print arr2[j] and increment j.
        //        4) If both are same then print any of them and increment both i and j.
        //        5) Print remaining elements of the larger array.
        int i = 0, j = 0;
        while (i < ar1.length && j < ar2.length) {
            if (ar1[i] < ar2[j]) {
                System.out.println(ar1[i] + " ");
                i++;
            } else if (ar2[j] < ar1[i]) {
                System.out.println(ar2[j] + " ");
                j++;
            } else {
                System.out.println(ar1[i] + " ");
                i++;
                j++;
            }
        }
        while (i < ar1.length) {
            System.out.println(ar1[i] + " ");
            i++;
        }
        while (j < ar2.length) {
            System.out.println(ar2[j] + " ");
            j++;
        }
    }

    static void intersect(int[] ar1, int[] ar2) {
    /*
    this method does not handle duplicates.O(m+n)
     */
        int i = 0, j = 0;
        while (i < ar1.length && j < ar2.length) {
            if (ar1[i] < ar2[j]) {
                i++;
            } else if (ar2[j] < ar1[i]) {
                j++;
            } else {
                System.out.println(ar1[i] + "");
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] ar1 = {1, 2, 3, 4};
        int[] ar2 = {1, 4, 6, 8, 9, 10};
        union(ar1, ar2);
        intersect(ar1, ar2);
    }
}
