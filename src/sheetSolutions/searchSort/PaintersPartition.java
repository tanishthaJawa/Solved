/*
Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array of n integers. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board. 

The problem is to find the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or only board {1} or nothing but not boards {2,4,5}.


Example 1:

Input: n = 5, k = 3, arr[] = {5,10,30,20,15}
Output: 35
Explanation: The most optimal way will be: Painter 1 allocation : {5,10}, Painter 2 allocation : {30}, Painter 3 allocation : {20,15}, Job will be done when all painters finish i.e. at time = max(5+10, 30, 20+15) = 35

The time complexity of the above approach is O(N * log (sum (arr[]))       .
*/

class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here

       /* long start = Arrays.stream(arr).max().getAsInt(), end = Arrays.stream(arr).sum();*/

      // Needed for gfg test case else above line also works
        long start = Integer.MIN_VALUE;
        long end = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>start){
                start=arr[i];
            }
            end+=arr[i];
        }
      
        long optimalTime = -1;
        while(start<=end){
            long mid = start +(end -start)/2;
            if(isValid(mid, arr, k, n)){
                optimalTime = mid;
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return optimalTime;
    }
    
    static boolean isValid(long mid, int [] arr, int k, int n){
        int painterCount = 1;
        long sum = 0;
        for(int i = 0; i< n;i++){
            sum+=arr[i];
            if(sum > mid){
                painterCount++;
                sum = arr[i];
            }
            if(painterCount > k){
                return false;
            }
        }
        
        return true;
    }
}
