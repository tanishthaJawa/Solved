package sheetSolutions.array;

/*
Given an array of integers (A[])  and a number x, find the smallest sub array with sum greater than the given value.
If such a sub array do not exist return 0 in that case.

Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).
 */
public class SmallestSubArrayWithSumGreaterThanX {
    /*
    It uses two pointers left and right to traverse the array and maintain a sliding window. It also maintains the current sum
    of the elements in the window. The while loop with right pointer moves the right endpoint of the window to the right and
    adds the element to the sum. The while loop with left pointer moves the left endpoint of the window to the right and
    subtracts the element from the sum until the sum is less than the target.If the length of the current sub rray is smaller
     than the minimum length found so far, the minimum length is updated.

     Time Complexity: O(n)
     */
    public static int smallestSubWithSum(int[] arr, int n, int x) {
        int minLen = n+1, left = 0, right = 0, sum = 0;
        while (right < n) {
             // Keep adding array elements while current sum
            // is smaller than or equal to x
            sum += arr[right];
            right++; // index is already incremented

            while (sum > x && left < n) {
                 // Update minimum length if needed
                if (right - left < minLen) {
                    minLen = right - left;
                }
                // remove starting elements to keep a sliding window to left. Check with example
                sum -= arr[left];
                left++;
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(smallestSubWithSum(new int[]{1, 4, 45, 6, 0, 19}, 6, 51));
    }
}
