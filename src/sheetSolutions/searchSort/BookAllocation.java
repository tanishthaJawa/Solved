/*
You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Examples:

Input: n = 4, arr[] = [12, 34, 67, 90], m = 2
Output: 113
Explanation: Allocation can be done in following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113, which is selected as the output.
*/

/*
Expected Time Complexity: O(n logn)
Expected Auxilliary Space: O(1)
*/
class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(m > n){
            return -1;
        }
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        long res = -1;
        
        while(start<=end){
            int mid = start+(end -start)/2;
            if(isValid(mid,m,arr)){
                res = mid;
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        
        return res;
    }
    
    private static boolean isValid(int mid, int m, int[] arr){
        int studentCount = 1;
        int sum = 0;
         
        for(int i = 0; i<arr.length ;i++){
            sum+=arr[i];
           
            if(sum > mid){
                studentCount ++;
                sum = arr[i];
            }
            if(studentCount > m){
                return false;
            }
        }
        return true;
    }
}
