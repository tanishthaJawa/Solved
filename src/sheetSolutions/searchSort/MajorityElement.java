/*
Given an array arr. Find the majority element in the array. If no majority exists, return -1.

A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

Examples:

Input: arr[] = [3, 1, 3, 3, 2]
Output: 3
Explanation: Since, 3 is present more than n/2 times, so it is the majority element.
*/

/*
Approach 1:
Using Moore’s Voting Algorithm (The Best Approach)
This is a two-step process:

The first step gives the element that may be the majority element in the array. If there is a majority element in an array, then this step will definitely return majority element, otherwise, it will return candidate for majority element.
Check if the element obtained from the above step is the majority element. This step is necessary as there might be no majority element. 
Follow the steps below to solve the given problem:

Loop through each element and maintains a count of the majority element, and a majority index, maj_index
If the next element is the same then increment the count if the next element is not the same then decrement the count.
if the count reaches 0 then change the maj_index to the current element and set the count again to 1.
Now again traverse through the array and find the count of the majority element found.
If the count is greater than half the size of the array, print the element
Else print that there is no majority element
Below is the implementation of the above idea: 
// Backend complete function template for JAVA
*/
class MajorityElement {
    /* Function to find the candidate for Majority */
    static int findCandidate(int a[], int size) {
        int maj_index = 0, count = 1;
        // use linear search to compute candidate for majority element
        for (int i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    // Function to check if the candidate occurs more than n/2 times
    static boolean isMajority(int a[], int size, int cand) {
        int count = 0;
        for (int i = 0; i < size; i++)
            if (a[i] == cand) count++;
        if (count > size / 2)
            return true;
        else
            return false;
    }

    static int majorityElement(int arr[]) {
        int size = arr.length;
        /* Find the candidate for Majority*/
        int cand = findCandidate(arr, size);

        /* Print the candidate if it is Majority*/
        if (isMajority(arr, size, cand) == true)
            return cand;
        else
            return -1;
    }
}

//Approach 2
// Backend complete function template for JAVA
/*
1. Sort array
2. If there is an element it will definitely start from middle element.
3. Find the firstOccurance and the lastoccurance of middle element
4. FInd the difference between the two and add 1 to it because this is difference between indexes. If it is greater than arr size/2 return this ele
5. else majority element doesn't exist

TC: O(n log n) because of sorting
SC: o(1)

*/

class Solution {
    /* Function to find the candidate for Majority */
    static int findCandidate(int a[], int size) {
        int maj_index = 0, count = 1;
        // use linear search to compute candidate for majority element
        for (int i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    // Function to check if the candidate occurs more than n/2 times
    static boolean isMajority(int a[], int size, int cand) {
        int count = 0;
        for (int i = 0; i < size; i++)
            if (a[i] == cand) count++;
        if (count > size / 2)
            return true;
        else
            return false;
    }

    static int majorityElement(int arr[]) {
        int size = arr.length;
        /* Find the candidate for Majority*/
        int cand = findCandidate(arr, size);

        /* Print the candidate if it is Majority*/
        if (isMajority(arr, size, cand) == true)
            return cand;
        else
            return -1;
    }
}
