import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallest {
  
  /* Use sorting */
  public static int kthSmallestUsingSort(int []arr, int k) {
     Arrays.sort(arr);
     return arr[k-1];
  }
  
  /* Using binary search

  To find the kth smallest element using binary search on the answer, we start by defining a search range based on the
  minimum and maximum values in the input array. In each iteration of binary search, we count the elements smaller than
  or equal to the midpoint and update the search range accordingly. This process continues until the range collapses to
  a single element, which is the kth smallest element.

- Intialize low and high to minimum and maximum element of the array denoting the range within which the answer lies.
- Apply Binary Search on this range. 
- If the selected element by calculating mid has less than K elements lesser to it then increase the number that is low = mid + 1.
- Otherwise, Decrement the high pointer, i.e high = mid.
- The Binary Search will end when only one element remains in the answer space that would be the answer.
  */
   public static int kSmallestUsingBinarySearch(int [] arr, int k){
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int i =0;i<arr.length; i++){
            low = Math.min(arr[i], low);
            high = Math.max(arr[i], high);
        }
        
        while(low<high){
            int mid = low+(high -low)/2;
            if(count(arr,mid)<k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    
    public static int count(int[]arr, int mid){
        int count =0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
            }
        }
        return count;
    }

  /* Using priority Queue */
   public static int kthSmallest(int []arr, int k){
     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
     for(int i =0;i<arr.length;i++){
       pq.offer(arr[i]);
       if(pq.size()>k){
         pq.poll();
       }
     }
     return pq.peek();
   }
  
  public static void main(String[] args) {
        int [] arr = {1,5,2,3,4};
        int k =3;
        System.out.println(kthSmallestUsingSort(arr, k));
        System.out.println(kSmallestUsingBinarySearch(arr, k));
        System.out.println(kthSmallest(arr, k));
    }
    
    
}
