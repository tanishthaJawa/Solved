package sheetSolutions.array;

/*
Given an array of positive integers. We need to make the given array a ‘Palindrome’. The only allowed operation is”merging” (of two
adjacent elements). Merging two adjacent elements means replacing them with their sum. The task is to find the minimum number of
merge operations required to make the given array a ‘Palindrome’.To make any array a palindrome, we can simply apply a merge
operation n-1 times where n is the size of the array (because a single-element array is always palindromic, similar to
single-character string). In that case, the size of array will be reduced to 1. But in this problem, we are asked to do it in
the minimum number of operations.

Example :

Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.

Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)

Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.
 */
public class MinOperationsToMakeArrayPalindrome {
    /*
     Let f(i, j) be minimum merging operations to make sub array arr[i..j] a palindrome. If i == j answer is 0. We start i from 0 and
      j from n-1.

    1.If arr[i] == arr[j], then there is no need to do any merging operations at index i or index j. Our answer in this case will be
         f(i+1, j-1).
    2.Else, we need to do merging operations. Following cases arise.
        1.If arr[i] > arr[j], then we should do merging operation at index j. We merge index j-1 and j, and update arr[j-1] = arr[j-1] +
             arr[j]. Our answer in this case will be 1 + f(i, j-1).
        2.For the case when arr[i] < arr[j], update arr[i+1] = arr[i+1] + arr[i]. Our answer in this case will be 1 + f(i+1, j).
    3.Our answer will be f(0, n-1), where n is the size of array arr[].
         */
    static int minOperations(int[] arr, int n) {
        int count = 0;
        for (int i = 0, j = n - 1;
             i <= j; ) { // no need to update counter as it is already updated in loop
            // If corner elements are same no need for merging
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] > arr[j]) { // we merge at the right end
                j--;
                arr[j] += arr[j + 1]; // does not give exception because counter is already decremented.
                count++;
            } else { // we merge at left end
                i++;
                arr[i] += arr[i - 1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {11, 14, 15, 99};
        System.out.println(minOperations(arr, arr.length));
    }
}
