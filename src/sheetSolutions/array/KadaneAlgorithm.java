package sheetSolutions.array;
/*
used to solve largest continuous sum of sub array problem
 */
/*
@author-tanishtha
 */
public class KadaneAlgorithm {
    //O(n)
  static  long maxSubarraySum(int arr[], int n){

        // Your code here
        long max_global=arr[0];
        long max_local=0;
        for(int i=0;i<n;i++){
            max_local=Math.max(arr[i],max_local+arr[i]);
            max_global=Math.max(max_global,max_local);
        }
        return max_global;
    }

    public static void main(String[] args) {
        int[]ar= {-1,-2,3,4,-9};
        long ans=maxSubarraySum(ar,5);
        System.out.println("Sum is:"+ans);

    }
}
