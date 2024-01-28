import java.io.*;
/*
Given an array having positive and negative numbers, our task is to arrange them in an alternate fashion such that 
every positive number is followed by a negative number and vice-versa maintaining the order of appearance. The number
of positive and negative numbers need not to be equal. If there are more positive numbers then they have to appear at
the end of the array , same condition for negative numbers also .

Examples: 

Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} */

/* 
To solve the problem in O(1) Auxiliary space follow the below idea:

The idea is to process the array from left to right. While processing, find the first out-of-place element in the 
remaining unprocessed array. An element is out of place if it is negative and at odd index (0-based index), or if 
it is positive and at even index (0-based index). Once we find an out-of-place element, we find the first element
after it with an opposite sign. We right rotate the subarray between these two elements (including these two).
*/
class RearrangeArray{
  
  public void rotate(int [] ar, int startIdx, int endIdx){
    int temp = ar[startIdx];
    for(int i = endIdx; endIdx> startIdx;endIdx++){
      ar[i] = ar[i-1];
    }
    ar[endIdx] = temp;
  }

  public void reArrange(int arr[], int n){
    int outOfPlace = -1;
    for(int i = 0; i<n; i++){
      if(outOfPlace >= 0){ // The first element at wrong place has been found
        
        // compare current element with outOfPlace element. Checks current element is postive and outOfPlace is negative and vice-versa
        if((arr[outOfPlace]>= 0  && arr[idx] < 0) || (arr[outOfPlace < 0] && arr[idx] >= 0)){
          rotate(arr, outOfPlace,idx);
        }

        // If distance between swapped elements is greater than 2, it skips over the current outOfPlace elemnt which we just moved to current pos
         if (index - outofplace >= 2)
               outofplace = outofplace + 2;
         else
               outofplace = -1;        
      }

      //  If no out of place element is isdentified in the current iteration, check if current element itself is out of place
      if(outOfPlace == -1){
        
        // check if current entry is out-of-place
       if ((arr[index] >= 0  && ((index & 0x01) == 0)) || (arr[index] < 0 && (index & 0x01) == 1))
         //(index & 0x01) == 0)  Ox)1 checks if least significant bit is of type ) or 1 
             outofplace = index;
      }
    }
  }
  void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
  
   public static void main(String[] args)
    {
        RearrangeArray rearrange = new RearrangeArray();

        int arr[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int n = arr.length;
 
        System.out.println("Given array is ");
        rearrange.printArray(arr, n);
 
        rearrange.rearrange(arr, n);
 
        System.out.println("RearrangeD array is ");
        rearrange.printArray(arr, n);
}
