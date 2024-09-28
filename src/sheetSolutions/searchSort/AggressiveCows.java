/*
You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.

Example 1:

Input:
n=5 
k=3
stalls = [1 2 4 8 9]
Output:
3
Explanation:
The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, 
which also is the largest among all possible ways.
*/
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int start = 1;  // min distance between two cows
        int end =  stalls[n-1] - stalls[0]; // max - min distance between two stalls ia the max distance
        int res = -1;
        if(k >n){
            return -1;
        }
        while(start<=end){
            int mid = start+(end - start)/2;
            if(isValid(mid,stalls,k)){
                res = mid;
                start = mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return res;
    }
    
    private static boolean isValid(int mid, int[]arr, int k){
        int numberOfCows = 1;
        int prevCowPlacement = arr[0]; // previous or first cow placement
        for(int i =0;i< arr.length;i++){
            if(arr[i] - prevCowPlacement >=mid){ // current distance between cows should be greater than or equal to the max distance we have defined(mid)
                numberOfCows++; // cow is placed
                prevCowPlacement = arr[i]; // cow is placed at arr[i] stall
            }
            if(numberOfCows >= k){
                return true;
            }
        }
        
        return false;
    }
}
