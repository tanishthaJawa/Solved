/*
Given an array arr[ ] of n elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

Examples

Input: arr[] = [1 3 2 4], n = 4
Output: 3 4 4 -1
Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.
*/

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Long> st =new Stack<>();
        long[] res = new long[arr.length];
        
        for(int i = n-1; i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }
            else if(st.peek()>arr[i]){
                res[i] = st.peek();
            }
            
            st.push(arr[i]);
        }
        return res;
    } 
}
